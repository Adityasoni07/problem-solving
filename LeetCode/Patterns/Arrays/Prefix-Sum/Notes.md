# Why Prefix Sum Works

## Idea

Prefix Sum is a **preprocessing technique**.

Do some work **once**, then answer **range queries** quickly.

Don't think of it as an algorithm.

Think of it as **cumulative thinking**.

---

## Why?

Suppose you're asked many times:

Sum from L to R

Calculating every range separately is slow.

Instead,

precompute cumulative sums once,

then answer every query in **O(1)**.

---

## Mental Model

At every index,

store **everything collected so far**.

Example

Array

3 5 2 7 4

Prefix Sum

3 8 10 17 21

Meaning

prefix[i]

=

Sum from index 0 to i

---

## Range Query

To find the sum from

L ... R

Think:

Whole Prefix

-

Unwanted Prefix

Formula

Range Sum

=

prefix[R]

-

prefix[L-1]

(If `L == 0`, the answer is simply `prefix[R]`.)

---

## Why is it called Prefix?

A **prefix** always starts from the beginning.

Example

3
3 5
3 5 2
3 5 2 7
3 5 2 7 4

Prefix Sum stores the sum of each of these prefixes.

---

## Recognition

Think Prefix Sum when you see:

- Range Sum
- Many Queries
- L...R
- Preprocessing
- Cumulative Information

Ask yourself:

> **Can I preprocess once and answer every range quickly?**

---

## Generalization

The idea is not limited to sums.

You can store any cumulative property.

- Prefix Sum
- Prefix XOR
- Prefix Frequency
- Prefix Balance
- Prefix GCD
- Prefix Minimum
- Prefix Maximum
- Prefix Bitmask

---

## Key Takeaways

- Prefix Sum is a **preprocessing technique**.
- Store cumulative information from the beginning.
- A range is:

Whole Prefix

-

Unwanted Prefix

- The real mindset is **cumulative thinking**, not just adding numbers.
