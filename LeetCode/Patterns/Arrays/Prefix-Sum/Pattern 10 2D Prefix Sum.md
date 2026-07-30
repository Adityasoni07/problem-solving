# Pattern 10: 2D Prefix Sum

## Big Idea

**2D Prefix Sum is not a new algorithm.**

It is simply the **2D extension of the Prefix Sum** you already know.

- **1D Prefix Sum** → Answer sum from **L to R**
- **2D Prefix Sum** → Answer sum inside a **rectangle**

---

# What Problem Does It Solve?

It solves problems involving **multiple rectangle sum queries** on a matrix.

Typical questions:

- Sum of a submatrix
- Rectangle sum
- Grid queries
- Image processing
- Heat maps
- Population in an area
- Game boards

---

# Recognition Checklist

Think **2D Prefix Sum** when you see:

- Matrix/Grid
- Many rectangle sum queries
- Sum of a region
- Sum inside a rectangle/box
- Multiple queries on the same matrix

### Keyword

> **Rectangle Sum Query**

---

# Review: 1D Prefix Sum

Suppose

```text
arr = [2,4,1,6,3]
```

Prefix

```text
2 6 7 13 16
```

Query

```text
Sum from index 1 to 3
```

Answer

```text
prefix[3] - prefix[0]
```

Why?

```text
0........3

minus

0

leaves

1........3
```

---

# What Changes in 2D?

Suppose we have

```text
1 2 3
4 5 6
7 8 9
```

Instead of asking

```text
L → R
```

we ask

```text
┌───────┐
│5   6  │
│8   9  │
└───────┘
```

Find the sum of this rectangle.

Now we have **two directions**:

- Horizontal
- Vertical

instead of only one.

---

# Naive Solution

For every query

```text
(r1,c1)

↓

(r2,c2)
```

visit every cell inside the rectangle.

If the matrix is

```text
1000 × 1000
```

and there are

```text
100000
```

queries,

this becomes extremely slow.

---

# The Big Idea

Exactly like 1D Prefix Sum,

precompute information **once**.

Then every rectangle query becomes

```text
O(1)
```

---

# What Does `prefix[r][c]` Store?

## Definition

`prefix[r][c]`

stores

> **The sum of every element from `(0,0)` to `(r,c)`**

Visual

Suppose

```text
1 2 3
4 5 6
7 8 9
```

Then

```text
prefix[1][1]
```

means

```text
┌──────┐
│1  2  │
│4  5  │
└──────┘
```

NOT

```text
5
```

Its value is

```text
1 + 2 + 4 + 5 = 12
```

Another example

```text
prefix[2][1]
```

means

```text
┌──────┐
│1 2   │
│4 5   │
│7 8   │
└──────┘
```

Everything from the top-left corner.

---

# Mental Model

Think of painting.

Whenever someone asks

```text
prefix[r][c]
```

Imagine painting everything from

```text
(0,0)
```

to

```text
(r,c)
```

Every prefix is simply a larger painted rectangle.

---

# Building the Prefix Matrix

Suppose

```text
1 2
3 4
```

We want

```text
prefix[1][1]
```

It should equal

```text
1 + 2 + 3 + 4 = 10
```

To compute it, use

```text
Left

+

Top

-

Overlap

+

Current
```

---

## Visual

Top

```text
┌──────┐
│1 2   │
└──────┘
```

-

Left

```text
┌───┐
│1  │
│3  │
└───┘
```

The shaded region

```text
┌───┐
│1  │
└───┘
```

appears in both.

So it is counted twice.

Subtract it once.

Then add the current cell.

---

# Building Formula

```text
prefix[r][c]

=

Top

+

Left

-

TopLeft

+

Current
```

---

## General Formula

```java
prefix[r][c] =
matrix[r][c]
+ top
+ left
- topLeft;
```

where

```java
top = (r > 0) ? prefix[r-1][c] : 0;

left = (c > 0) ? prefix[r][c-1] : 0;

topLeft =
(r > 0 && c > 0)
? prefix[r-1][c-1]
: 0;
```

---

# Why Subtract TopLeft?

Both

- Top rectangle
- Left rectangle

contain the **same top-left rectangle**.

So it gets counted twice.

Subtract it once.

### Important

The overlap is **NOT** just the diagonal cell.

It is the **entire top-left rectangle** represented by

```text
prefix[r-1][c-1]
```

---

# Rectangle Query

Suppose we need

```text
(r1,c1)

↓

(r2,c2)
```

Take the biggest rectangle first.

Then remove unwanted parts.

Visual

```text
Entire Prefix

┌─────────────────────┐
│█████████████████████│
│█████████████████████│
│████ Desired ███████ │
│█████████████████████│
└─────────────────────┘
```

Remove

- Top strip
- Left strip

Now the top-left rectangle has been removed twice.

Add it back once.

---

# Rectangle Query Formula

```text
Answer

=

Whole Rectangle

-

Top Strip

-

Left Strip

+

TopLeft Rectangle
```

---

## Query Formula

```java
sum =
prefix[r2][c2]
- top
- left
+ topLeft;
```

where

```java
top =
(r1 > 0)
? prefix[r1-1][c2]
: 0;

left =
(c1 > 0)
? prefix[r2][c1-1]
: 0;

topLeft =
(r1 > 0 && c1 > 0)
? prefix[r1-1][c1-1]
: 0;
```

---

# Relationship with 1D Prefix Sum

## 1D

```text
Answer

=

Right Prefix

-

Left Prefix
```

---

## 2D

```text
Answer

=

Whole Rectangle

-

Top Strip

-

Left Strip

+

TopLeft Rectangle
```

The extra

```text
+ TopLeft
```

is needed because the top-left rectangle is removed twice.

---

# Complexity

| Operation    | Complexity     |
| ------------ | -------------- |
| Build Prefix | O(rows × cols) |
| Each Query   | O(1)           |
| Space        | O(rows × cols) |

---

# Common Mistakes

### Mistake 1

Forgetting to subtract the overlap.

Result: Top-left rectangle gets counted twice.

---

### Mistake 2

Ignoring boundary conditions.

Always check

```java
r > 0
```

and

```java
c > 0
```

before accessing neighbors.

---

### Mistake 3

Misunderstanding `prefix[r][c]`.

It does **NOT** store

- row sum
- column sum

It stores

> **The sum of the entire rectangle from `(0,0)` to `(r,c)`**

---

# Pattern Summary

## Build

```text
Current
+
Top
+
Left
-
TopLeft
```

---

## Query

```text
Whole Rectangle
-
Top Strip
-
Left Strip
+
TopLeft Rectangle
```

---

# Problems

### Foundation

- **304. Range Sum Query 2D – Immutable** ⭐⭐⭐⭐⭐

### Intermediate

- **1314. Matrix Block Sum**
- **2428. Maximum Sum of an Hourglass**

### Advanced

- **1074. Number of Submatrices That Sum to Target**
  - 2D Prefix Sum + HashMap

---

# Golden Rule

> **2D Prefix Sum extends 1D Prefix Sum from lines to rectangles. Each `prefix[r][c]` stores the sum of the rectangle from `(0,0)` to `(r,c)`. Any rectangle sum query can then be answered in `O(1)` time using Inclusion–Exclusion:**
>
> **Whole Rectangle − Top Strip − Left Strip + TopLeft Rectangle.**
