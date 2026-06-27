# Pattern 3: Partition (Dutch National Flag)

## Idea

Divide the array into **regions** while scanning it only once.

You're **not building** a new array.

You're placing every element into its correct region.

---

## Mental Model

Use three pointers.

- **low** → Next position for the left region.
- **mid** → Current element.
- **high** → Next position for the right region.

```text
Left Region | Unknown | Right Region
```

---

## Universal Pattern

```java
low = 0;
mid = 0;
high = n - 1;

while (mid <= high) {

    if (/* belongs to left region */) {
        swap(low, mid);
        low++;
        mid++;
    }
    else if (/* belongs to middle region */) {
        mid++;
    }
    else {
        swap(mid, high);
        high--;
    }
}
```

**Rule:** After swapping with `high`, **do not move `mid`** because the new element is still unknown.

---

## When to Use (Recognition)

Think **Partition** when you see:

- Rearrange array
- In-place solution
- Constant space
- Few fixed categories
- Around a pivot

---

## Common Uses

- Three-way partition (0, 1, 2)
- Partition around a pivot
- Separate two categories
- Group elements into regions

---

## Important Problems

- 75. Sort Colors
- 905. Sort Array By Parity
- 922. Sort Array By Parity II
- 2161. Partition Array According to Given Pivot
- Quick Sort Partition

---

## Key Difference

- **Same Direction (Slow/Fast):** Build or modify the array.
- **Partition:** Place every element into its correct region.

---

## Complexity

- **Time:** `O(n)`
- **Space:** `O(1)`
