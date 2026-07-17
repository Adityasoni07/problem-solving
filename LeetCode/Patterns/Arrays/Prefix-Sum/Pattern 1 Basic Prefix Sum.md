# Pattern 1: Basic Prefix Sum

## Goal

Answer **range sum queries** efficiently.

Instead of computing every range separately,

preprocess the array once.

---

## When to Use

Think **Basic Prefix Sum** when you see:

- Range Sum
- `L...R`
- Many Queries
- Static Array

---

## Definition

prefix[i]

=

Sum of elements from index 0 to i

Example

Array

3 5 2 7 4

Prefix

3 8 10 17 21

---

## Build Prefix Array

### Formula

prefix[0] = nums[0]

prefix[i] = prefix[i-1] + nums[i]

### Java

java
int n = nums.length;

int[] prefix = new int[n];

prefix[0] = nums[0];

for (int i = 1; i < n; i++) {
prefix[i] = prefix[i - 1] + nums[i];
}

---

## Range Sum Query

Think:

Whole Prefix

-

Unwanted Prefix

=

Desired Range

### Formula

If L == 0

Answer = prefix[R]

Else

Answer = prefix[R] - prefix[L-1]

### Java

java
int sum;

if (l == 0)
sum = prefix[r];
else
sum = prefix[r] - prefix[l - 1];

---

## Complexity

| Operation    | Time         |
| ------------ | ------------ |
| Build Prefix | **O(N)**     |
| One Query    | **O(1)**     |
| Total        | **O(N + Q)** |

---

## Common Mistakes

- Using `prefix[R] - prefix[L]`
- Forgetting the `L == 0` case
- Thinking Prefix Sum only works for addition

---

## Related Prefix Variants

The same cumulative-thinking idea extends to:

- Prefix XOR
- Prefix Frequency
- Prefix Balance
- Prefix Modulo
- Prefix Bitmask

---

## Practice Order

### Easy

1. 1480. Running Sum of 1d Array
2. 303. Range Sum Query – Immutable
3. 724. Find Pivot Index

### Medium

4. 1991. Find the Middle Index in Array
5. 2574. Left and Right Sum Differences
6. 238. Product of Array Except Self _(Prefix + Suffix)_

---

## One-Line Memory Trick

**Precompute cumulative sums once, then answer every range query in O(1) using:**

Whole Prefix

-

Unwanted Prefix
