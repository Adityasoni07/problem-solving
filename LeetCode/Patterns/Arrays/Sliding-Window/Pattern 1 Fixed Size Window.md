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

643. Maximum Average Subarray I
644. Maximum Number of Vowels in a Substring of Given Length
645. Minimum Recolors to Get K Consecutive Black Blocks
646. Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold
647. Maximum Sum of Distinct Subarrays With Length K
648. Grumpy Bookstore Owner
649. Permutation in String
650. Find All Anagrams in a String
651. K Radius Subarray Averages
652. Maximum Points You Can Obtain from Cards
653. Substring with Concatenation of All Words (optional challenge)

---

## Complexity

- **Time:** `O(n)`
- **Space:** Depends on the problem (`O(1)` or extra data structure if needed)
