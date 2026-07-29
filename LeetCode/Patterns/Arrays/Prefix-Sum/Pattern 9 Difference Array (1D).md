# Pattern 9: Difference Array (1D)

## Big Idea

Difference Array is **not a new algorithm**.

It is a Prefix-based technique used to perform **multiple range updates efficiently**.

Instead of updating every element in a range, we only mark:

- Where the update **starts**
- Where the update **ends**

Later, one Prefix Sum spreads the update across the entire range.

---

# When Should I Think About This Pattern?

Look for problems containing phrases like:

- Add x to every element from L to R
- Increase/Decrease values in a range
- Many interval updates
- Thousands of range operations
- Apply all updates first
- Return the final array

Keyword:

> **Range Update**

NOT

> **Range Query**

---

# Problem

Suppose

```
arr = [5, 2, 8, 1, 3]
```

Update

```
+4 from index 1 to 3
```

Naively

```
5 6 12 5 3
```

Time

```
O(R-L+1)
```

If there are

```
100000 updates
```

each covering

```
100000 elements
```

Total becomes

```
O(N × Q)
```

Too slow.

---

# Core Idea

Instead of updating every element,

mark only

```
Start of update

↓

End of update
```

Then later,

one Prefix Sum automatically fills the entire range.

---

# Mental Model (Water Flow)

Imagine pouring water into a canal.

Instead of filling every point manually,

place

```
+x
```

where water starts

and

```
-x
```

where water stops.

When water flows (Prefix Sum),

every point in between automatically receives x.

Think

```
Start Flow

↓

Continue Flow

↓

Stop Flow
```

---

# Example

Initial array

```
0 0 0 0 0 0
```

Operation

```
Add 5 from index 1 to 4
```

Instead of updating

```
0 5 5 5 5 0
```

Store only

| Index | 0   | 1   | 2   | 3   | 4   | 5   |
| ----: | --- | --- | --- | --- | --- | --- |
|  Diff | 0   | 5   | 0   | 0   | 0   | -5  |

Meaning

```
Start adding 5 here

↓

Keep adding

↓

Stop after index 4
```

---

# Recover Final Array

Take Prefix Sum

```
Diff

0 5 0 0 0 -5
```

↓

```
Prefix

0
5
5
5
5
0
```

Exactly the updated array.

---

# Why Does It Work?

Suppose

```
+5 at index L

-5 at index R+1
```

Prefix behaves like

```
Before L

0
```

↓

```
At L

+5
```

↓

```
Between L and R

Still +5
```

↓

```
At R+1

+5 + (-5)

↓

0
```

The update automatically disappears.

---

# General Rule

To add x in

```
[L...R]
```

Do

```java
diff[L] += x;

if (R + 1 < n)
    diff[R + 1] -= x;
```

After all updates

```java
for (int i = 1; i < n; i++) {
    diff[i] += diff[i - 1];
}
```

Now the Prefix Sum spreads every update.

---

# Two Ways to Use Difference Array

Suppose

```
arr = [10,20,30,40,50]
```

Update

```
+5 from index 1 to 3
```

Final answer should be

```
10 25 35 45 50
```

---

# Option 1 — Convert Original Array into Difference Array

### Step 1

Original

```
10 20 30 40 50
```

Convert

```java
diff[0] = arr[0];

for(int i=1;i<n;i++)
    diff[i]=arr[i]-arr[i-1];
```

Result

```
10 10 10 10 10
```

These are **differences between consecutive elements**.

---

### Step 2

Apply update

```
+5 from 1 to 3
```

Only boundary changes

```java
diff[1]+=5;
diff[4]-=5;
```

Now

```
10 15 10 10 5
```

---

### Step 3

Take Prefix Sum

```
10
25
35
45
50
```

Recovered array

```
10 25 35 45 50
```

### Mental Model

```
Original Array

↓

Convert into Difference Array

↓

Apply Updates

↓

Prefix Sum

↓

Updated Array
```

---

# Option 2 — Keep Original Array Unchanged (Most Common)

Instead of converting the original array,

create another array

```
updateDiff
```

Initially

```
0 0 0 0 0
```

---

### Step 1

Apply update

```
+5 from 1 to 3
```

Boundary updates

```
0 5 0 0 -5
```

---

### Step 2

Take Prefix Sum

```
0
5
5
5
0
```

Meaning

```
Every position should receive

0
5
5
5
0
```

---

### Step 3

Add these increments to original array

Original

```
10 20 30 40 50
```

-

Increment

```
0 5 5 5 0
```

=

```
10 25 35 45 50
```

### Mental Model

```
Original Array

+

Range Updates

↓

Increment Array

↓

Answer
```

---

# Difference Between Both Options

## Option 1

```
Original

↓

Difference Array

↓

Updates

↓

Prefix Sum

↓

Answer
```

The original array itself becomes a Difference Array.

---

## Option 2 (Interview Favorite)

```
Original Array

↓

Leave It As It Is

↓

Create Difference Array Only For Updates

↓

Prefix Sum

↓

Add Increments To Original

↓

Answer
```

The original array never changes until the very end.

---

# Which Option Should I Use?

### Option 1

Use when

- Data is already stored as Difference Array.
- You want to work completely in Difference representation.

Rare in interviews.

---

### Option 2 ⭐⭐⭐⭐⭐

Use when

- Original array is given.
- Need to apply many updates.
- Need final updated array.

This is used in **90% of interview problems**.

---

# Difference Array vs Prefix Sum

| Prefix Sum         | Difference Array                  |
| ------------------ | --------------------------------- |
| Fast Range Queries | Fast Range Updates                |
| Build Prefix First | Build Updates First               |
| Query Anytime      | Update Everything Then Build Once |

Remember

```
Prefix Sum

↓

Answer Queries Fast
```

```
Difference Array

↓

Apply Updates Fast
```

---

# Recognition Checklist

Think Difference Array if

✅ Many range updates

✅ Add/Subtract over intervals

✅ Final array after all updates

✅ Need efficient updates

---

# Complexity

Suppose

```
N = array size

Q = updates
```

Naive

```
O(N × Q)
```

Difference Array

```
Process Updates

O(Q)
```

```
Build Prefix

O(N)
```

Total

```
O(N+Q)
```

---

# Common Mistakes

### Mistake 1

Forgetting to stop update

Wrong

```java
diff[L]+=x;
```

Correct

```java
diff[L]+=x;

if(R+1<n)
    diff[R+1]-=x;
```

---

### Mistake 2

Forgetting Prefix Sum

Difference Array is **not** the answer.

Always rebuild using Prefix Sum.

---

### Mistake 3

Accessing

```java
diff[R+1]
```

when

```
R = n-1
```

Always check

```java
if(R+1<n)
```

---

# General Skeleton (Option 2)

```java
int[] diff = new int[n];

for(Update u : updates){

    diff[u.left] += u.value;

    if(u.right + 1 < n)
        diff[u.right + 1] -= u.value;
}

for(int i=1;i<n;i++)
    diff[i]+=diff[i-1];

for(int i=0;i<n;i++)
    arr[i]+=diff[i];
```

---

# Genuine Interview Problems

### Foundation

**370. Range Addition**

Classic Difference Array.

---

### Advanced

**1109. Corporate Flight Bookings**

Range additions.

---

### Advanced

**1094. Car Pooling**

Difference Array on a timeline.

---

### Variation

**2381. Shifting Letters II**

Range updates on characters.

---

# Relationship with Prefix Sum

```
Prefix Family

├── Prefix Sum
│      Used for Fast Range Queries
│
└── Difference Array
       Used for Fast Range Updates
```

They are opposite ideas.

---

# Golden Rule

> **Difference Array transforms expensive range updates into two boundary operations (`+x` at the start and `-x` after the end). A single Prefix Sum later spreads those updates across the entire range, reducing the complexity from `O(N × Q)` to `O(N + Q)`.**
