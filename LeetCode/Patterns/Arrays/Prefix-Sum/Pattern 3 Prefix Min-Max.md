# Pattern 4: Prefix Min / Max

## Idea

Store the **minimum** or **maximum** value seen from the beginning up to each index.

Unlike Prefix Sum and Prefix XOR, Prefix Min/Max **cannot** answer arbitrary range queries.

---

## Definition

### Prefix Maximum

prefixMax[i]

=

Maximum element from index 0 to i

### Prefix Minimum

prefixMin[i] = Minimum element from index 0 to i

---

## Build Prefix

### Prefix Max
java
int[] prefixMax = new int[n];

prefixMax[0] = nums[0];

for (int i = 1; i < n; i++) {
    prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
}

### Prefix Min
java
int[] prefixMin = new int[n];

prefixMin[0] = nums[0];

for (int i = 1; i < n; i++) {
    prefixMin[i] = Math.min(prefixMin[i - 1], nums[i]);
}

---

## Mental Model

At every index, ask:

> **What is the maximum (or minimum) seen so far?**

Not:

> **What is the maximum (or minimum) between `L` and `R`?**

---

## Why It Cannot Answer Range Queries

There is **no inverse operation** for `max()` or `min()`.

Once a maximum or minimum is chosen,

the prefix array loses information about where it came from.

So you cannot remove the unwanted prefix.

---

## Recognition

Think **Prefix Min / Max** when you see:

* Maximum So Far
* Minimum So Far
* Running Maximum
* Running Minimum
* Largest Before Current Index
* Smallest Before Current Index

The keyword is:
text
"So Far"

---

## When NOT to Use

For arbitrary **Range Minimum/Maximum Queries (`L...R`)**,

Prefix Min/Max is **not sufficient**.

Instead, consider:

* Sparse Table *(Static Arrays)*
* Segment Tree *(Dynamic Updates)*

---

## Complexity

| Operation | Time     |
| --------- | -------- |
| Build     | **O(N)** |
| Lookup    | **O(1)** |
| Space     | **O(N)** |

---

## Practice Problems

1. **915. Partition Array into Disjoint Intervals**
2. **2012. Sum of Beauty in the Array**

Both use:

* Prefix Max
* Suffix Min

---

## Comparison

| Pattern    | Build Prefix | Range Query via Prefix |
| ---------- | :----------: | :--------------------: |
| Prefix Sum |       ✅      |            ✅           |
| Prefix XOR |       ✅      |            ✅           |
| Prefix AND |       ✅      |            ❌           |
| Prefix OR  |       ✅      |            ❌           |
| Prefix Min |       ✅      |            ❌           |
| Prefix Max |       ✅      |            ❌           |

---

## Golden Rule

**Prefix Min/Max stores the best value seen from the beginning up to the current index. It is not a technique for answering arbitrary range minimum or maximum queries.**
