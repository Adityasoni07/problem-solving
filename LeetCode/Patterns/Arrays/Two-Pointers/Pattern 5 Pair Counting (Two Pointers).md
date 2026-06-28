# Pattern 5: Pair Counting (Two Pointers)

## Idea

Count **multiple pairs at once** instead of checking every pair.

Sort the array first.

Use two pointers to count valid pairs in `O(n)`.

---

## Mental Model

If one pair is valid,

then several other pairs are automatically valid.

Count them together instead of one by one.

---

## Universal Pattern

### Count `sum <= K`

```java
left = 0;
right = n - 1;

while (left < right) {

    if (sum <= K) {
        count += (right - left);
        left++;
    } else {
        right--;
    }
}
```

---

### Count `sum >= K`

```java
left = 0;
right = n - 1;

while (left < right) {

    if (sum >= K) {
        count += (right - left);
        right--;
    } else {
        left++;
    }
}
```

---

## Recognition

Think **Pair Counting** when you see:

- Count pairs
- Number of pairs
- Pair sum in range
- Pair difference in range
- At most
- At least
- Exactly

---

## CP Trick

```text
Exactly(K)
=
AtMost(K)
-
AtMost(K-1)
```

```text
[L, R]
=
AtMost(R)
-
AtMost(L-1)
```

Always try to convert:

- Exactly
- Between
- Range

into **AtMost**.

---

## Common Uses

- Count pairs with sum ≤ K
- Count pairs with sum < K
- Count pairs with sum ≥ K
- Count pairs with sum > K
- Count pairs with sum in [L, R]
- Count pairs with difference ≤ K

---

## Important Problems

- 2563. Count the Number of Fair Pairs
- 611. Valid Triangle Number
- 2824. Count Pairs Whose Sum Is Less Than Target

---

## Complexity

- Sort: `O(n log n)`
- Two Pointers: `O(n)`
- Overall: `O(n log n)`
