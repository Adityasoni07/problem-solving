# Prefix Frequency

## Relationship with Prefix Sum + HashMap

Prefix Frequency is **not a new algorithm**.

It is a specialization of **Prefix Sum + HashMap**.

Prefix Sum + HashMap
│
├── Store Frequency ← Prefix Frequency
├── Store First Index ← Longest Subarray
├── Store Latest Index
└── Store Other Information

The only difference is **what the HashMap stores**.

---

# Goal

Count how many previous prefixes satisfy a condition.

The keyword is:

> **Count**

---

# When to Use

Think **Prefix Frequency** whenever you see:

- Count Subarrays with Sum = K
- Count Subarrays Divisible by K
- Count Binary Subarrays with Sum = Goal
- Count Nice Subarrays
- Number of Subarrays

Whenever the problem asks:

> **"How many subarrays...?"**

Immediately think:

> **Store Prefix Sum → Frequency**

---

# Core Idea

Instead of storing

Prefix Sum → Index

store

Prefix Sum → Frequency

The frequency answers one question:

> **How many times has this prefix appeared?**

---

# Why Frequency?

Suppose

nums = [1, -1, 1, -1]

Prefix sums become

1
0
1
0

Frequency table

0 → 2

1 → 2

Notice that the same prefix sum appears multiple times.

Each occurrence represents a different possible starting position.

So one lookup may contribute

1 subarray

2 subarrays

10 subarrays

depending on the stored frequency.

---

# Example

Array

1 2 3

Target

K = 3

Initialize

map = {0 → 1}

### Index 0

Current Prefix

1

Need

1 - 3 = -2

Not found.

Store

1 → 1

---

### Index 1

Current Prefix

3

Need

3 - 3 = 0

Frequency of

0

is

1

Answer becomes

1

Store

3 → 1

---

### Index 2

Current Prefix

6

Need

6 - 3 = 3

Frequency of

3

is

1

Answer becomes

2

---

# Why Add Frequency?

Suppose

Prefix 5

appears

4 times

Current Prefix

12

Needs

5

Should we add

1

No.

We add

4

because there are **4 different starting positions**.

That is why we store frequencies instead of indices.

---

# Visual Intuition

Suppose the prefix sequence is

0

2

5

2

5

2

Frequency table becomes

0 → 1

2 → 3

5 → 2

Later,

Current Prefix needs

2

Answer increases by

3

because there are **three previous prefixes equal to 2**.

---

# General Template

java
Map<Integer, Integer> freq = new HashMap<>();

freq.put(0, 1);

int prefix = 0;
int ans = 0;

for (int num : nums) {

    prefix += num;

    ans += freq.getOrDefault(prefix - target, 0);

    freq.put(prefix,
             freq.getOrDefault(prefix, 0) + 1);

}

---

# Order Matters

Always follow this order:

1. Update Prefix
2. Count Previous Matching Prefixes
3. Increase Current Prefix Frequency

Updating the frequency before checking may count the current prefix as a previous one.

---

# Mental Model

Imagine every prefix sum is a checkpoint.

Instead of asking

> **Where was checkpoint 5?**

ask

> **How many times have I visited checkpoint 5?**

Every visit creates another possible starting point.

---

# Recognition Checklist

Ask yourself:

- Am I counting subarrays?
- Can multiple previous prefixes satisfy the condition?
- Do I need every occurrence instead of only the first?

If the answer is **Yes**,

store

Prefix Sum → Frequency

---

# Common Beginner Mistakes

### Mistake 1

Using

map.put(prefix, index);

Instead of

map.put(prefix, frequency);

For counting problems, indices are unnecessary.

---

### Mistake 2

Writing:

Wrong : ans++;

Correct : ans += frequency;

because multiple previous prefixes may satisfy the condition.

---

### Mistake 3

Forgetting

map.put(0, 1);

Without it, subarrays that begin at index `0` are missed.

---

# Genuine LeetCode Problems

## Foundation

- **560. Subarray Sum Equals K** ⭐⭐⭐⭐⭐

## Counting

- **974. Subarray Sums Divisible by K**
- **930. Binary Subarrays With Sum**
- **1248. Count Number of Nice Subarrays**

These four problems are enough to master Prefix Frequency.

---

# Prefix HashMap vs Prefix Frequency

| Pattern          | HashMap Stores | Purpose                 |
| ---------------- | -------------- | ----------------------- |
| Longest Subarray | First Index    | Maximize Length         |
| Prefix Frequency | Frequency      | Count Subarrays         |
| Existence Check  | Boolean / Set  | Detect a Valid Subarray |

---

# Golden Rule

Whenever the problem asks:

> **"How many subarrays...?"**

Think:

> **Every matching previous prefix contributes one answer.**

Therefore,

store

Prefix Sum → Frequency

instead of an index.

---

# One-Line Memory Trick

**Prefix Frequency is the counting version of Prefix Sum + HashMap. Every matching previous prefix represents another valid starting position, so store frequencies—not indices.**
