# Pattern 1.1: Sum Problems (Extension of Opposite Ends)

## Idea

Convert every **k-Sum** problem into a **2Sum** problem.

- Fix `(k - 2)` numbers.
- Solve the remaining **2Sum** using opposite-end two pointers.

---

## Flow

### 2Sum

Fix: **0**

```text
L ---------------- R
```

Use two pointers directly.

---

### 3Sum

Fix: **1**

```text
i

L ---------------- R
```

Fix one number, then solve the remaining 2Sum.

---

### 3Sum Closest

Same as **3Sum**.

Difference:

- Keep updating the closest sum.
- Return immediately if `sum == target`.

---

### 4Sum

Fix: **2**

```text
i

    j

L ---------------- R
```

Fix two numbers, then solve the remaining 2Sum.

---

### 5Sum

Fix: **3**

```text
i

    j

        k

L ---------------- R
```

Fix three numbers, then solve the remaining 2Sum.

---

## General Rule

```text
kSum

Fix (k - 2) numbers

↓

Solve remaining 2Sum using
Opposite-End Two Pointers
```

---

## Pointer Movement

```text
sum < target
→ left++

sum > target
→ right--

sum == target
→ Answer Found
```

---

## Time Complexity

```text
2Sum  → O(n)

3Sum  → O(n²)

4Sum  → O(n³)

5Sum  → O(n⁴)

kSum  → O(n^(k-1))
```
