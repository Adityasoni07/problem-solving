# Pattern 2: Same Direction (Slow / Fast)

## Idea

Use two pointers moving in the **same direction**.

- **Fast** scans every element.
- **Slow** builds or modifies the final answer.

```text
S F →
```

---

## Mental Model

👀 **Fast = Scanner**

- Visits every element.

✍️ **Slow = Writer**

- Writes only useful elements.

---

## Universal Pattern

```java
int slow = 0;

for (int fast = 0; fast < n; fast++) {

    if (/* current element is useful */) {
        nums[slow] = nums[fast];
        slow++;
    }
}

return slow;   // or modified array
```

---

## When to Use (Recognition)

Think **Slow/Fast** when you see:

- Remove
- Delete
- Keep
- Compress
- Move
- Rearrange
- In-place modification
- Stable order
- No extra array

---

## Common Uses

- Remove duplicates
- Remove elements
- Move zeroes
- Keep valid elements
- Compress array/string
- Rearrange while preserving order

---

## Important Problems

- 26. Remove Duplicates from Sorted Array
- 27. Remove Element
- 283. Move Zeroes
- 80. Remove Duplicates from Sorted Array II
- 443. String Compression
- 905. Sort Array By Parity
- 1089. Duplicate Zeros
- 75. Sort Colors
- 88. Merge Sorted Array
