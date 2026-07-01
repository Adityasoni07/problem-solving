# Pattern 5: Pair Counting

## Idea

Count **multiple valid pairs at once** instead of checking every pair individually.

There are **two different techniques** depending on the condition.

---

# Type 1: Pair Sum Counting (Opposite Ends)

## When to Use

- Pair **sum**
- Sum in range
- Sum ≤ K
- Sum ≥ K
- Exactly K (using AtMost trick)

Uses **Opposite-End Two Pointers**.

```text
L ---------------- R
```

---

## Universal Pattern

### Count `sum <= K`

```java
left = 0;
right = n - 1;

while (left < right) {

    if (nums[left] + nums[right] <= K) {
        count += (right - left);
        left++;
    } else {
        right--;
    }
}
```

---

### Count `sum >= K`

```java
left = 0;
right = n - 1;

while (left < right) {

    if (nums[left] + nums[right] >= K) {
        count += (right - left);
        right--;
    } else {
        left++;
    }
}
```

---

## CP Trick

```text
Exactly(K)
=
AtMost(K)
-
AtMost(K-1)
```

```text
[L, R]
=
AtMost(R)
-
AtMost(L-1)
```

---

## Problems

- 2563. Count the Number of Fair Pairs
- 2824. Count Pairs Whose Sum Is Less Than Target

---

# Type 2: Pair Difference Counting (Sliding Window)

## When to Use

- Pair difference
- Difference ≤ K
- Difference < K
- Sorted array
- Window expands and shrinks

Uses **Sliding Window**.

```text
L →→→→ R
```

---

## Universal Pattern

```java
Arrays.sort(nums);

left = 0;

for (right = 0; right < n; right++) {

    while (/* invalid */)
        left++;

    count += (right - left);
}
```

---

### Invalid Condition

| Need           | Invalid Condition |
| -------------- | ----------------- |
| Difference ≤ K | `difference > K`  |
| Difference < K | `difference >= K` |

---

## Mental Model

For every fixed **right**,

count how many valid pairs **end at right**.

The window always contains valid left indices.

---

## Problems

- 220. Contains Duplicate III
- 532. K-diff Pairs in an Array _(one solution uses two pointers after sorting)_
- 2006. Count Number of Pairs With Absolute Difference K _(sorting variant)_

---

## Recognition

### Pair Sum Counting

Think:

- Pair sum
- Sum in range
- AtMost
- Exactly
- Fair pairs

↓

Use **Opposite Ends**

---

### Pair Difference Counting

Think:

- Difference
- Distance
- Window
- Maximum allowed difference

↓

Use **Sliding Window**

---

## Complexity

### Pair Sum Counting

- Sort: `O(n log n)`
- Two Pointers: `O(n)`

Overall: `O(n log n)`

### Pair Difference Counting

- Sort: `O(n log n)`
- Sliding Window: `O(n)`

Overall: `O(n log n)`
