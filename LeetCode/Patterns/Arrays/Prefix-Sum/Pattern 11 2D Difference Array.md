# Pattern 11: 2D Difference Array

## Big Idea

2D Difference Array is **not a new algorithm**.

It is simply the **2D version of the 1D Difference Array**.

Just like **2D Prefix Sum** answers many rectangle queries efficiently,

**2D Difference Array** performs many rectangle updates efficiently.

Think:

```text
2D Prefix Sum
Rectangle Query
```

vs

```text
2D Difference Array
Rectangle Update
```

---

# What Problem Does It Solve?

It solves problems involving **multiple rectangle updates**.

Typical questions:

- Add a value to every cell inside a rectangle.
- Increment many submatrices.
- Perform thousands of range updates on a matrix.

Instead of updating every cell one by one,

we mark only the rectangle boundaries.

---

# Recognition Pattern

Whenever you see:

- Rectangle updates
- Increment submatrix
- Add value inside a rectangle
- Many range updates on a matrix

Think immediately:

> **2D Difference Array**

---

# Naive Approach

Suppose we have

```text
0 0 0 0
0 0 0 0
0 0 0 0
0 0 0 0
```

Now someone says:

Add **5** inside this rectangle.

```text
      c0 c1 c2 c3

r0     .  .  .  .

r1     . [ ][ ] .

r2     . [ ][ ] .

r3     .  .  .  .
```

Naively,

we update every cell.

```java
for(each cell inside rectangle)
    matrix[i][j] += 5;
```

If there are many updates,

this becomes slow.

---

# Review — 1D Difference Array

To add

```text
+5
```

from

```text
L .......... R
```

We never updated every element.

Instead we only marked

```java
diff[L] += 5;

if (R + 1 < n)
    diff[R + 1] -= 5;
```

Later,

Prefix Sum spread the update across the entire range.

---

# What Changes in 2D?

A rectangle has

- Top
- Bottom
- Left
- Right

instead of

- Start
- End

So,

instead of marking **2 positions**,

we mark **4 corners**.

---

# Mental Model

Imagine pouring water into a rectangular field.

You don't pour water into every square.

You simply place markers at the rectangle boundaries.

Later,

2D Prefix Sum spreads the values automatically.

```text
Rectangle Update

↓

Corner Marks

↓

2D Prefix Sum

↓

Whole Rectangle Updated
```

---

# The Four-Corner Rule

To add `val`

inside rectangle

```text
(r1,c1)

↓

(r2,c2)
```

Update only four positions.

```java
diff[r1][c1] += val;

if (r2 + 1 < m)
    diff[r2 + 1][c1] -= val;

if (c2 + 1 < n)
    diff[r1][c2 + 1] -= val;

if (r2 + 1 < m && c2 + 1 < n)
    diff[r2 + 1][c2 + 1] += val;
```

Visualize the signs.

```text
            c1        c2+1

r1          +          -

r2+1        -          +
```

---

# Why These Signs?

Think exactly like the 1D Difference Array.

```text
+
```

Start the update.

```text
-
```

Stop it vertically.

```text
-
```

Stop it horizontally.

```text
+
```

Restore the overlap because it was removed twice.

This is exactly the **Inclusion-Exclusion Principle**.

---

# Build the Final Matrix

After processing all updates,

run a normal **2D Prefix Sum**.

```java
curr = diff[i][j];

if (i > 0)
    curr += diff[i - 1][j];

if (j > 0)
    curr += diff[i][j - 1];

if (i > 0 && j > 0)
    curr -= diff[i - 1][j - 1];

diff[i][j] = curr;
```

The resulting matrix is the final updated matrix.

---

# Time Complexity

Suppose

- Matrix size = **m × n**
- Updates = **Q**

Naive

```text
O(Q × m × n)
```

2D Difference Array

Mark updates

```text
O(Q)
```

Build final matrix

```text
O(m × n)
```

Overall

```text
O(Q + m × n)
```

---

# Relationship with Previous Patterns

```text
1D Prefix Sum
        ↓
1D Difference Array
        ↓
2D Prefix Sum
        ↓
2D Difference Array
```

Notice the pattern.

```text
Prefix Sum
→ Range Query

Difference Array
→ Range Update
```

Both have

- 1D version
- 2D version

---

# Common Mistakes

### ❌ Using `+` instead of `-`

Wrong

```java
diff[r2 + 1][c1] += val;
```

Correct

```java
diff[r2 + 1][c1] -= val;
```

---

### ❌ Forgetting the overlap

Always restore

```java
diff[r2 + 1][c2 + 1] += val;
```

---

### ❌ Forgetting boundary checks

Always check

```java
r2 + 1 < m
```

and

```java
c2 + 1 < n
```

before updating.

---

# Practice Problems

1. **2536. Increment Submatrices by One** ⭐

Best introduction to the pattern.

---

# Golden Rule

Need many rectangle sums?

→ **2D Prefix Sum**

Need many rectangle updates?

→ **2D Difference Array**
