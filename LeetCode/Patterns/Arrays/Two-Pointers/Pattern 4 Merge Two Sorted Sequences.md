# Pattern 4: Merge Two Sorted Sequences

## Idea

Use two pointers to **combine two sorted sequences** while maintaining sorted order.

You're **not searching**.

You're **not modifying**.

You're **combining**.

---

## Mental Model

Use one pointer for each sequence.

```text
A: i →

B: j →
```

Always compare the current elements.

The smaller one belongs next in the answer.

Move **only** that pointer.

---

## Universal Pattern

```java
int i = 0;
int j = 0;

while (i < n && j < m) {

    if (A[i] <= B[j]) {
        // Use A[i]
        i++;
    } else {
        // Use B[j]
        j++;
    }
}

// Process remaining elements
while (i < n) {
    i++;
}

while (j < m) {
    j++;
}
```

---

## When to Use (Recognition)

Think **Merge** when you see:

- Two sorted arrays
- Two sorted sequences
- Need sorted output
- Compare current elements
- Process both sequences together

---

## Common Uses

- Merge two sorted arrays
- Union of sorted arrays
- Intersection of sorted arrays
- Difference of sorted arrays
- Merge step of Merge Sort

---

## Important Problems

- 88. Merge Sorted Array
- 350. Intersection of Two Arrays II
- 2570. Merge Two 2D Arrays by Summing Values

### CP Problems

- Union of Two Sorted Arrays
- Intersection of Two Sorted Arrays
- Difference of Two Sorted Arrays
- Symmetric Difference of Two Sorted Arrays
- Merge Step of Merge Sort

---

## Key Difference

- **Opposite Ends:** Find a relationship between two ends.
- **Same Direction:** Build/modify one array.
- **Partition:** Place elements into regions.
- **Merge:** Combine two sorted sequences.

---

## Complexity

- **Time:** `O(n + m)`
- **Space:** Depends on the problem (`O(1)` or `O(n + m)`)
