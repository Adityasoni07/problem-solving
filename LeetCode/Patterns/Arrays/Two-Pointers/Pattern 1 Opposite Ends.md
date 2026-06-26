# Pattern 1: Opposite Ends (Two Pointers)

## Idea

Use two pointers:

- `left = 0`
- `right = n - 1`

Both pointers start from opposite ends of the array.

```
L ---------------- R
```

At every step:

- Move `left` to increase the answer/value.
- Move `right` to decrease the answer/value.
- Never move both randomly.
- The pointer movement depends on the current condition.

This pattern is mostly used on **sorted arrays** or when the answer depends on both ends.

---

## General Flow

```
left = 0
right = n - 1

while (left < right) {

    // Process

    if (condition)
        left++;
    else
        right--;
}
```

---

## Problems

- 167. Two Sum II
- 977. Squares of a Sorted Array
- 11. Container With Most Water
- 881. Boats to Save People
- 15. 3Sum
- 16. 3Sum Closest
- 18. 4Sum
