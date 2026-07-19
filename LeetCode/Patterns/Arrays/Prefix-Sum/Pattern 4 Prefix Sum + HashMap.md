# Pattern 6: Prefix Sum + HashMap

## Goal

Find or count subarrays while scanning the array **once**.

Unlike Basic Prefix Sum, the subarray boundaries are **not given**.

You must discover them during traversal.

---

## When to Use

Think **Prefix Sum + HashMap** when you see:

- Subarray Sum = K
- Count Subarrays
- Longest Subarray
- Running Sum + Previous History

---

## Core Idea

Suppose the current prefix sum is:

currentPrefix

To find a subarray with sum `K`:

Subarray Sum = Current Prefix - Previous Prefix

Rearrange:

Previous Prefix = Current Prefix - K

At every index, ask:

> **Have I seen `currentPrefix - K` before?**

If **Yes**, a valid subarray exists.

---

## Mental Model

Think of prefix sums as **checkpoints**.

0 → 3 → 8 → 10 → 17

Standing at the current checkpoint,

look backward for the checkpoint that differs by `K`.

The HashMap remembers every previous checkpoint.

---

## Universal Template

java
Map<Integer, Integer> map = new HashMap<>();

map.put(0, 1);

int prefix = 0;

for (int num : nums) {

    prefix += num;

    // Check currentPrefix - K

    // Update map

}

---

## HashMap Stores

The **key** is always:

Prefix Sum

The value depends on the problem:

- Frequency
- First Index
- Latest Index

---

## Initialization

java
map.put(0, 1);

This handles subarrays that begin at index `0`.

---

## Order Matters

1. Update Prefix

2. Check Required Prefix

3. Update HashMap

Checking before updating prevents counting the current prefix as a previous one.

---

## Common Mistakes

- Using a `HashSet` instead of a `HashMap`
- Forgetting `map.put(0, 1)`
- Updating the map before checking

---

## Practice Problems

### Foundation

- **560. Subarray Sum Equals K**

### Counting

- **930. Binary Subarrays With Sum**
- **1248. Count Number of Nice Subarrays**

### Longest

- **325. Maximum Size Subarray Sum Equals K**
- **525. Contiguous Array**
- **1124. Longest Well-Performing Interval**

---

## Master Formula

Subarray Sum = Current Prefix - Previous Prefix

Rearrange:

Previous Prefix = Current Prefix - Desired Sum

At every index, ask:

> **Have I seen the required previous prefix before?**

If yes, the HashMap immediately tells you where (or how many times), allowing an **O(N)** solution.

---

## One-Line Memory Trick

**Prefix Sum + HashMap = Store previous prefix sums so the required starting point of a subarray can be found in O(1) while scanning once.**
