# Pattern 4: Count Windows

## Idea

Count the number of **subarrays/substrings** that satisfy a condition.

Unlike Pattern 2 and Pattern 3, we don't find the longest or shortest window.

We count **all valid windows**.

---

## Mental Model

When the current window becomes valid,

don't count just one window.

Count **all windows** that are guaranteed to be valid.

---

## Structure 1 — Count Windows Ending at `right`

If every subarray ending at `right` is valid:

```java
ans += right - left + 1;
```

### Universal Template

```java
int left = 0;
long ans = 0;

for (int right = 0; right < n; right++) {

    // Add nums[right]

    while (window is invalid) {

        // Remove nums[left]

        left++;
    }

    ans += right - left + 1;
}
```

### Why?

For the current `right`, every starting index from

```text
left ... right
```

forms a valid window.

---

## Structure 2 — Count Windows Starting at `left`

If the current window is already valid:

```java
ans += n - right;
```

### Universal Template

```java
int left = 0;
long ans = 0;

for (int right = 0; right < n; right++) {

    // Add nums[right]

    while (window is valid) {

        ans += n - right;

        // Remove nums[left]

        left++;
    }
}
```

### Why?

Once the window is valid,

every larger ending index

```text
right ... n-1
```

is also valid.

---

## Exactly K Trick

Many problems ask:

```text
Exactly K
```

Convert them into:

```text
Exactly(K)
=
AtMost(K)
-
AtMost(K-1)
```

This is one of the most important counting techniques.

---

## Recognition

Think Pattern 4 when you see:

- Count
- Number of
- Total
- How many
- At Most K
- Exactly K

---

## Common Mistakes

- Using `Math.max()` or `Math.min()`
- Counting only one window
- Forgetting:

```text
Exactly(K)
=
AtMost(K)
-
AtMost(K-1)
```

---

# Problems

## Structure 1 — `ans += right - left + 1`

- 2762. Continuous Subarrays
- 713. Subarray Product Less Than K
- 2302. Count Subarrays With Score Less Than K
- 795. Number of Subarrays with Bounded Maximum
- 930. Binary Subarrays With Sum
- 1248. Count Number of Nice Subarrays
- 992. Subarrays with K Different Integers

---

## Structure 2 — `ans += n - right`

- 2799. Count Complete Subarrays in an Array
- 1358. Number of Substrings Containing All Three Characters
- 3297. Count Substrings That Can Be Rearranged to Contain a String I
- 3298. Count Substrings That Can Be Rearranged to Contain a String II

---

## Notes

Not every **counting** problem is a sliding window problem.

Example:

- 1915. Number of Wonderful Substrings → Prefix + Bitmask (Not Sliding Window)

Always classify problems by the **algorithm**, not by words like "count" or "number".
