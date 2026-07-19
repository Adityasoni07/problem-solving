# Pattern 2: Prefix XOR

## Goal

Answer **range XOR queries** efficiently.

Instead of computing the XOR for every range separately,

preprocess the array once.

---

## When to Use

Think **Prefix XOR** when you see:

- Range XOR
- Subarray XOR
- Bitwise Queries
- Many Queries

---

## XOR Properties

a ^ a = 0
a ^ 0 = a
a ^ b ^ a = b

XOR is:

- Commutative
- Associative

These properties make Prefix XOR possible.

---

## Definition

prefixXor[i]

=

XOR of elements from index 0 to i

Example

Array

5 2 7 3

Prefix XOR

5 7 0 3

---

## Build Prefix XOR

### Formula

prefixXor[0] = nums[0]

prefixXor[i] = prefixXor[i-1] ^ nums[i]

### Java

java
int n = nums.length;

int[] prefixXor = new int[n];

prefixXor[0] = nums[0];

for (int i = 1; i < n; i++) {
prefixXor[i] = prefixXor[i - 1] ^ nums[i];
}

---

## Range XOR Query

Think:

Whole Prefix

^

Unwanted Prefix

=

Desired Range

### Formula

If L == 0

Answer = prefixXor[R]

Else

Answer = prefixXor[R] ^ prefixXor[L-1]

### Java

java
int ans;

if (l == 0)
ans = prefixXor[r];
else
ans = prefixXor[r] ^ prefixXor[l - 1];

---

## Why It Works

Unlike addition,

XOR removes the unwanted prefix by **canceling** it.

a ^ a = 0

Example

(5 ^ 2 ^ 7 ^ 3) ^ 5

=

5 ^ 5 ^ 2 ^ 7 ^ 3

=

2 ^ 7 ^ 3

---

## Prefix Sum vs Prefix XOR

| Prefix Sum       | Prefix XOR       |
| ---------------- | ---------------- |
| `+`              | `^`              |
| Remove using `-` | Remove using `^` |
| `a - a = 0`      | `a ^ a = 0`      |

The mindset is the same.

Only the operation changes.

---

## Complexity

| Operation        | Time         |
| ---------------- | ------------ |
| Build Prefix XOR | **O(N)**     |
| One Query        | **O(1)**     |
| Total            | **O(N + Q)** |

---

## Common Mistakes

- Using `prefixXor[R] - prefixXor[L-1]`
- Forgetting `a ^ a = 0`
- Treating XOR like addition

---

## Practice Order

1. **1310. XOR Queries of a Subarray** ⭐⭐⭐⭐⭐
2. **2433. Find The Original Array of Prefix XOR**
3. **1829. Maximum XOR for Each Query**
4. **1442. Count Triplets That Can Form Two Arrays of Equal XOR**

---

## One-Line Memory Trick

**Prefix XOR removes the unwanted prefix by XORing it again, because XOR cancels itself (`a ^ a = 0`).**
