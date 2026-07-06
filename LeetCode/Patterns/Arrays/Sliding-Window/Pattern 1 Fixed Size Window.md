# Pattern 1: Fixed Size Window

## Idea

The **window size never changes**.

Expand the window until it reaches size `k`.

Then, for every new element added, remove one old element.

---

## Mental Model

Window size is always **k**.

```text
----  →  ----  →  ----
```

The window slides, but its size never changes.

---

## Universal Pattern

```java
left = 0;

for (right = 0; right < n; right++) {

    // Add nums[right]

    if (right - left + 1 > k) {
        // Remove nums[left]
        left++;
    }

    if (right - left + 1 == k) {
        // Process current window
    }
}
```

---

## Recognition

Think **Fixed Size Window** when you see:

- Exactly `k`
- Size `k`
- Length `k`
- Every `k` elements
- Window of size `k`

---

## Common Uses

- Maximum sum of size `k`
- Minimum sum of size `k`
- Average of size `k`
- Count windows of size `k`
- Maximum/Minimum in every window

---

## Important Problems

- 643. Maximum Average Subarray I
- 1456. Maximum Number of Vowels in a Substring of Given Length
- 1343. Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold
- 2461. Maximum Sum of Distinct Subarrays With Length K
- 1423. Maximum Points You Can Obtain from Cards

---

## Complexity

- **Time:** `O(n)`
- **Space:** Depends on the problem (`O(1)` or extra data structure if needed)
