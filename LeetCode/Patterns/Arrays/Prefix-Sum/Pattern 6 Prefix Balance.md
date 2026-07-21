# Prefix Balance

## Relationship with Prefix Sum + HashMap

Prefix Balance is **not a new algorithm**.

It is a specialization of **Prefix Sum + HashMap**.

Prefix Sum + HashMap
│
├── Prefix Frequency (Counting)
├── Prefix Balance (Equal Counts)
├── Prefix Modulo (Divisibility)
├── Prefix State (Multiple Categories / Bitmask)
└── Prefix Index (Longest / Shortest / Existence)

The new idea is **how we define the prefix value**.

Instead of storing the numeric prefix sum, we store a **running balance**.

---

# Goal

Detect subarrays where **two categories occur equally often**.

The keyword is:

> **Equal**

---

# When to Use

Think **Prefix Balance** whenever you see:

- Equal number of 0s and 1s
- Equal number of vowels and consonants
- Equal number of uppercase and lowercase letters
- Equal number of A and B
- Equal number of positive and negative numbers (after transformation)

Whenever the problem asks:

> **Equal counts**

Immediately think:

> **Transform → Balance → HashMap**

---

# Core Idea

Instead of maintaining two counters,

zeros = ?

ones = ?

convert the problem into a single running value.

### Transformation

Convert one category into **+1**

Convert the other category into **-1**

Example

1 → +1

0 → -1

Now the array

0 1 0 1

becomes

-1 +1 -1 +1

The problem is now reduced to computing a running prefix sum (called **balance**).

---

# What Does Balance Mean?

Balance = (Number of +1) - (Number of -1)

If

Balance = 0

then

#(+1)

=

#(-1)

which means the two categories occur equally often.

---

# Why Does the Same Balance Matter?

Suppose

Balance = 3

appears at

Index 2

Index 8

At both positions,

(+1 Count) - (-1 Count) = 3

The balance didn't change.

That means

Increase in +1

=

Increase in -1

So the subarray between those indices is perfectly balanced.

This is exactly the same principle as Prefix Sum.

Current Prefix - Previous Prefix = 0

The only difference is that the prefix now represents a **balance** instead of a numeric sum.

---

# Visual Example

Original Array

0 1 1 0 0 1

Transform

-1 +1 +1 -1 -1 +1

Running Balance

| Index | Balance |
| ----: | ------: |
|    -1 |       0 |
|     0 |      -1 |
|     1 |       0 |
|     2 |       1 |
|     3 |       0 |
|     4 |      -1 |
|     5 |       0 |

Notice that

Balance = 0

appears multiple times.

Every repeated balance creates a balanced subarray.

---

# HashMap Strategy

For the **longest balanced subarray**, store

Balance → First Index

Why?

The earliest occurrence produces the maximum possible length.

Exactly the same idea as the longest subarray sum problem.

---

# Java Template

Map<Integer, Integer> map = new HashMap<>();

map.put(0, -1);

int balance = 0;
int ans = 0;

for (int i = 0; i < nums.length; i++) {

    if (nums[i] == 1)
        balance++;
    else
        balance--;

    if (map.containsKey(balance)) {

        ans = Math.max(ans, i - map.get(balance));

    } else {

        map.put(balance, i);

    }

}

---

# Mental Model

Imagine the balance is your **altitude**.

0

↓

-1

↓

0

↓

1

↓

0

Whenever you return to the same altitude,

everything in between is perfectly balanced.

---

# Recognition Checklist

Ask yourself:

- Are there equal numbers of two categories?
- Can one category become **+1** and the other **-1**?
- Am I looking for the longest or count of balanced subarrays?

If the answer is **Yes**,

think

Transform

↓

Prefix Balance

↓

HashMap

---

# Common Beginner Mistakes

### Mistake 1

Using the original values instead of transforming them.

Always convert the two categories into

+1

-1

---

### Mistake 2

Keeping separate counters instead of a running balance.

The transformation reduces the problem to a standard Prefix Sum problem.

---

### Mistake 3

Storing the latest index.

For longest balanced subarrays,

store the **first occurrence** of each balance.

---

### Mistake 4

Forgetting

map.put(0, -1);

Without it, balanced subarrays starting at index `0` are missed.

---

# Genuine LeetCode Problems

## Foundation

- **525. Contiguous Array** ⭐⭐⭐⭐⭐

The classic Prefix Balance problem.

---

## Variations

- **1124. Longest Well-Performing Interval**

Transformation:

Tiring Day → +1

Non-Tiring Day → -1

Then apply the Prefix Balance idea with a slight variation.

---

# Prefix Sum vs Prefix Balance

| Prefix Sum                   | Prefix Balance                 |
| ---------------------------- | ------------------------------ |
| Store numeric sum            | Store transformed balance      |
| Search for `prefix - target` | Search for the same balance    |
| Original values              | Transformed values (`+1 / -1`) |

---

# Golden Rule

Whenever a problem asks for **equal counts of two categories**, transform one category into **+1** and the other into **-1**.

Then solve it as a **Prefix Sum + HashMap** problem using the running balance.

---

# One-Line Memory Trick

**Prefix Balance converts an equal-count problem into a running balance problem. Whenever the same balance appears again, the subarray between those two positions is perfectly balanced.**
