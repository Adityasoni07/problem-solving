# Pattern 3 — Shrink Until Valid (Minimum)

## Goal

Find the **minimum** or **shortest** window that satisfies a condition.

Unlike Pattern 2, we don't want the largest valid window.

We want the smallest one.

---

# Pattern 2 vs Pattern 3

The biggest difference is **your goal**, not the code.

| Pattern   | Goal                  |
| --------- | --------------------- |
| Pattern 2 | Longest valid window  |
| Pattern 3 | Shortest valid window |

---

# Pattern 2 — Expand Until Valid (Longest)

Think:

> **"I want the biggest valid window."**

If the current window is valid,

keep expanding.

Only shrink when it becomes invalid.

### Golden Rule

**Expand whenever possible.**

**Shrink only when necessary.**

---

# Pattern 3 — Shrink Until Valid (Minimum)

Think:

> **"I want the smallest valid window."**

The moment the window becomes valid,

try making it smaller immediately.

Keep shrinking until it becomes invalid.

The **last valid window** is your candidate.

### Golden Rule

**Shrink whenever possible.**

**Expand only when necessary.**

---

# Visualization

### Pattern 2

```text
Expand

[]

↓

[ ]

↓

[   ]

↓

[      ]

↓

Invalid

[        X]

↓

Shrink
```

---

### Pattern 3

```text
Expand

[]

↓

[ ]

↓

[   ]

↓

Valid

[--------]

↓

Shrink

 [------]

↓

Shrink

  [----]

↓

Invalid
```

---

# Code Difference

## Pattern 2

```java
for (right = 0; right < n; right++) {

    add(nums[right]);

    while (window is invalid) {

        remove(nums[left]);

        left++;
    }

    ans = Math.max(ans, right - left + 1);
}
```

The answer is updated **after** the window becomes valid again.

---

## Pattern 3

```java
for (right = 0; right < n; right++) {

    add(nums[right]);

    while (window is valid) {

        ans = Math.min(ans, right - left + 1);

        remove(nums[left]);

        left++;
    }
}
```

The answer is updated **before** removing, because the current window is already a valid candidate.

---

# Recognition

Think Pattern 3 when you see:

- Minimum
- Shortest
- Smallest
- Cover
- Contains All
- Reach Target
- At Least

---

# Common Problems

## Arrays

- 209. Minimum Size Subarray Sum
- 2875. Minimum Size Subarray in Infinite Array _(Advanced)_
- 862. Shortest Subarray with Sum at Least K _(Monotonic Queue, not pure sliding window)_

## Strings

- 76. Minimum Window Substring
- 1234. Replace the Substring for Balanced String
- 2516. Take K of Each Character From Left and Right

---

# Problems NOT in Pattern 3

Although they contain shrinking, they belong elsewhere.

### Pattern 2

- 1658. Minimum Operations to Reduce X to Zero

Reason:

Transform into **Longest Subarray with Sum = target**.

---

### Two Pointers

- 1574. Shortest Subarray to be Removed to Make Array Sorted

Reason:

Uses **Prefix + Suffix Merge**, not a sliding window.

---

### Pattern 4

- 1358. Number of Substrings Containing All Three Characters
- 3297. Count Substrings That Can Be Rearranged to Contain a String I
- 3298. Count Substrings That Can Be Rearranged to Contain a String II

Reason:

The goal is **counting**, not finding the minimum window.

---

# One-Line Memory Trick

### Pattern 2

**Need the longest?**

Protect valid windows.

---

### Pattern 3

**Need the shortest?**

Destroy valid windows.

---

# Important Note

Pattern 3 works when the window property is **monotonic**.

For example:

- Positive numbers
- Character frequencies
- Coverage constraints

If removing elements can make the condition unpredictable (such as with negative numbers), a pure sliding window no longer works.

Example:

- 862. Shortest Subarray with Sum at Least K

This problem uses **Prefix Sum + Monotonic Deque**, not a pure sliding window.
