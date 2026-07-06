# Sliding Window

## Definition

Sliding Window is a technique used to process **contiguous subarrays or substrings** efficiently.

Instead of checking every possible window independently, maintain a window using two pointers (`left` and `right`) and update it while moving through the array or string.

Most Sliding Window problems run in **O(n)** because each pointer moves forward at most `n` times.

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

    // Answer
}
```

---

# Patterns

```
Sliding Window

│
├── Pattern 1
│   Fixed Size Window
│
├── Pattern 2
│   Expand Until Valid
│   (Longest)
│
├── Pattern 3
│   Shrink Until Valid
│   (Minimum)
│
├── Pattern 4
│   Count Windows
│
└── Pattern 5
    Multi Constraint Window
```
