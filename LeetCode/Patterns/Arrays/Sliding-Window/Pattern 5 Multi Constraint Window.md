# Pattern 5: Multi-Constraint Sliding Window (Variation)

## Idea

Some sliding window problems require maintaining **multiple conditions** at the same time.

The window is valid only when **all constraints** are satisfied.

Example:

- Distinct ≤ K
- Sum ≤ X
- Frequency ≤ M

All must be true simultaneously.

---

## Universal Template

```java
int left = 0;

for (int right = 0; right < n; right++) {

    // Add nums[right]

    while (any constraint is violated) {

        // Remove nums[left]

        left++;
    }

    // Update answer
}
```

The only difference is that the validity check becomes more complex.

---

## Key Idea

Multi-constraint is **not a separate sliding window pattern**.

It is simply:

- Pattern 2 (Longest) + multiple constraints
- Pattern 3 (Minimum) + multiple constraints

The goal still determines the pattern.

---

## Examples

### Pattern 2 + Multiple Constraints

- 340. Longest Substring with At Most K Distinct Characters
- 2958. Length of Longest Subarray With at Most K Frequency
- 1438. Longest Continuous Subarray With Absolute Difference Less Than or Equal to Limit _(uses Monotonic Deques)_

---

### Pattern 3 + Multiple Constraints

- 76. Minimum Window Substring
- 1234. Replace the Substring for Balanced String
- 2516. Take K of Each Character From Left and Right

---

## Recognition

Don't ask:

> "How many constraints are there?"

Instead ask:

- Need the **longest** window? → Pattern 2
- Need the **shortest** window? → Pattern 3
- Need to **count** windows? → Pattern 4

The constraints only determine **how you maintain the window**, not **which pattern** you're solving.
