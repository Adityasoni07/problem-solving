# Prefix Modulo

## Relationship with Prefix Sum + HashMap

Prefix Modulo is **not a new algorithm**.

It is a specialization of **Prefix Sum + HashMap**.

Prefix Sum + HashMap
│
├── Prefix Frequency
│ key = Prefix Sum
│
├── Prefix Balance
│ key = Balance
│
├── Prefix Modulo
│ key = Prefix Sum % K
│
└── Prefix Index
value = First / Last Index

The algorithm never changes.

Only the **HashMap key** changes.

---

# Goal

Solve problems involving **divisibility**.

The keyword is:

> **Divisible**

---

# When to Use

Think **Prefix Modulo** whenever you see:

- Divisible by K
- Multiple of K
- Remainder
- Modulo

Typical questions:

- Count subarrays whose sum is divisible by K.
- Does there exist a subarray whose sum is divisible by K?
- Remove the shortest subarray to make the total divisible by K.

---

# Core Idea

Instead of storing

Prefix Sum

store

Prefix Sum % K

Example

nums = [4, 5, 1]

K = 5

Prefix sums

4

9

10

Prefix modulo

4

4

0

---

# Why Store Modulo?

Suppose

Current Prefix = 37

Previous Prefix = 17

Difference

37 - 17 = 20

Since

20

is divisible by

5

look at their remainders.

37 % 5 = 2

17 % 5 = 2

The remainders are equal.

This is the key observation.

---

# Mathematical Property

If

A % K = B % K

Then

(A - B) is divisible by K

This single property is the entire reason Prefix Modulo works.

---

# Intuition

Think of numbers as belonging to **remainder groups**.

For

K = 5

Group 0

0 5 10 15 20 25 ...

Group 1

1 6 11 16 21 26 ...

Group 2

2 7 12 17 22 27 ...

If two prefix sums fall into the **same remainder group**,

their difference is divisible by `K`.

---

# Visual Example

Array

4 5 1

K

5

| Index | Prefix | Modulo |
| ----: | -----: | -----: |
|    -1 |      0 |      0 |
|     0 |      4 |      4 |
|     1 |      9 |      4 |
|     2 |     10 |      0 |

Notice

Modulo = 4

appears twice.

9 - 4 = 5

which is divisible by `5`.

Later,

Modulo = 0

appears again.

10 - 0 = 10

which is also divisible by `5`.

Every repeated remainder creates a valid divisible subarray.

---

# HashMap Strategy

The **HashMap key** is

Prefix Sum % K

The value depends on the problem.

| Problem             | Store                   |
| ------------------- | ----------------------- |
| Count Subarrays     | Frequency               |
| Longest / Existence | First Index             |
| Shortest Subarray   | Latest / Required Index |

---

# Java Template (Counting)

java
Map<Integer, Integer> freq = new HashMap<>();

freq.put(0, 1);

int prefix = 0;
int ans = 0;

for (int num : nums) {

    prefix += num;

    int mod = prefix % k;

    if (mod < 0)
        mod += k;

    ans += freq.getOrDefault(mod, 0);

    freq.put(mod,
        freq.getOrDefault(mod, 0) + 1);

}

---

# Why Normalize Negative Modulo?

Java can produce negative remainders.

Example

-2 % 5 = -2

Mathematically,

-2 ≡ 3 (mod 5)

Both belong to the same remainder group.

Normalize it using
java
if (mod < 0)
mod += k;

This is a Java-specific requirement.

---

# Mental Model

Imagine every prefix joins a **remainder group**.

Whenever the current prefix enters a group you've already visited,

everything between those two visits has a sum divisible by `K`.

---

# Recognition Checklist

Ask yourself:

- Is the problem about divisibility?
- Does it mention multiples of `K`?
- Does it involve remainders or modulo?

If the answer is **Yes**,

think

Prefix Sum

↓

Prefix % K

↓

HashMap

---

# Common Beginner Mistakes

### Mistake 1

Storing

Prefix Sum

instead of

Prefix Sum % K

---

### Mistake 2

Forgetting
java
if (mod < 0)
mod += k;

Negative numbers will break the logic in Java.

---

### Mistake 3

Using indices instead of frequencies in counting problems.

For counting,

store

Modulo → Frequency

---

# Genuine LeetCode Problems

## Foundation

- **974. Subarray Sums Divisible by K** ⭐⭐⭐⭐⭐

The classic Prefix Modulo problem.

---

## Variations

- **523. Continuous Subarray Sum**

  Store **Modulo → First Index** because the goal is existence (with length ≥ 2).

- **1590. Make Sum Divisible by P**

  Uses **Modulo → Index** to remove the shortest subarray.

These three problems cover the core interview applications.

---

# Prefix Frequency vs Prefix Modulo

| Prefix Frequency         | Prefix Modulo           |
| ------------------------ | ----------------------- |
| Key = Prefix Sum         | Key = Prefix Sum % K    |
| Numeric Target           | Divisibility Target     |
| Search `prefix - target` | Search Equal Remainders |
| Frequency of Prefix      | Frequency of Modulo     |

---

# Golden Rule

Whenever a problem involves **divisibility**, don't store the full prefix sum.

Store

Prefix Sum % K

If two prefixes have the **same remainder**, the subarray between them has a sum divisible by `K`.

---

# One-Line Memory Trick

**Prefix Modulo is the divisibility version of Prefix Sum + HashMap. Equal remainders mean the difference between two prefix sums is divisible by `K`.**
