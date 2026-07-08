# Pattern 2: Expand Until Valid (Longest)

## Idea

Find the **longest** or **maximum-length** window that satisfies a condition.

The window keeps expanding while it is valid.

Shrink **only** when it becomes invalid.

---

## Mental Model

**Expand whenever possible.**

**Shrink only when necessary.**

Never shrink a valid window.

---

## Universal Template

```java
int left = 0;

for (int right = 0; right < n; right++) {

    // Add nums[right]

    while (window is invalid) {

        // Remove nums[left]

        left++;
    }

    ans = Math.max(ans, right - left + 1);
}
```

---

## Window Life Cycle

1. Expand (`right++`)
2. Check validity
3. Shrink until valid
4. Update answer

**Invariant:** At the end of every iteration, the window is **valid**.

---

## Recognition

Think **Expand Until Valid** when you see:

- Longest
- Maximum Length
- Largest Size
- At Most
- Can Replace
- Can Flip
- Can Delete
- Can Remove

---

## Golden Rule

- Expand whenever possible.
- Shrink only when necessary.
- Always use **while**, not **if**.

---

## Common Uses

- Longest subarray with sum ≤ K
- Longest subarray with at most K zeros
- Longest subarray with at most K distinct elements
- Longest substring after at most K replacements
- Longest window satisfying a condition

---

## Important Problems

- 1004. Max Consecutive Ones III
- 1493. Longest Subarray of 1's After Deleting One Element
- 904. Fruit Into Baskets
- 2958. Length of Longest Subarray With at Most K Frequency
- 1695. Maximum Erasure Value
- 1838. Frequency of the Most Frequent Element

---

## Complexity

- **Time:** `O(n)`
- **Space:** Depends on the problem (`O(1)` or extra data structure)
