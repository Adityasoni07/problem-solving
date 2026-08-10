# Pattern 2 — Linked List Reversal

Pattern 2 — Reversal
│
├── 1. Full Reverse
├── 2. Reverse Between
├── 3. Reverse in K Groups
├── 4. Reverse Alternate K Groups
└── 5. Reverse for Palindrome

Before learning these variations, master one core technique:

> **Three-Pointer Reversal — `prev`, `curr`, `next`**

---

# 1. What Does Reversal Mean?

Given:

1 → 2 → 3 → 4 → null

We want:

4 → 3 → 2 → 1 → null

We are **not moving nodes in memory**.

We are changing the direction of the `next` pointers.

Initially:

1.next = 2
2.next = 3
3.next = 4
4.next = null

After reversal:

1.next = null
2.next = 1
3.next = 2
4.next = 3

Therefore:

> **Linked List Reversal = Change the direction of the arrows.**

---

# 2. Why Can't We Simply Reverse the Arrow?

Suppose:

1 → 2 → 3 → 4

We do:
java
curr.next = prev;

For the first node:

1 ← null

2 → 3 → 4

We have destroyed:

1 → 2

So how do we reach `2`?

We can't, unless we saved it first.

This gives us the most important rule:

> **Before changing `curr.next`, save the original `curr.next`.**

---

# 3. The Three Pointers

We maintain three pointers:

prev
curr
next

Their responsibilities are:

prev → already reversed portion

curr → current node being reversed

next → remaining unreversed portion

This is the **Reversal Invariant**.

---

# 4. Initial State

For:

1 → 2 → 3 → 4 → null

initialize:
java
ListNode prev = null;
ListNode curr = head;

Conceptually:

prev
↓
null

curr
↓
1 → 2 → 3 → 4 → null

At this point:

reversed portion = empty

unreversed portion = entire list

---

# 5. Step 1 — Save `next`

Before changing anything:
java
ListNode next = curr.next;

Now:

prev curr next
↓ ↓ ↓
null 1 2 → 3 → 4

Why?

Because we are about to destroy:

1 → 2

So we first save the node `2`.

---

# 6. Step 2 — Reverse the Arrow

Now:
java
curr.next = prev;

The list becomes:

1 → null

The arrow has been reversed.

Before:

1 → 2

After:

1 → null

The remaining list is still accessible through `next`:

next
↓
2 → 3 → 4

---

# 7. Step 3 — Move `prev`

java
prev = curr;

Now:

prev
↓
1 → null

The reversed portion has grown by one node.

---

# 8. Step 4 — Move `curr`

java
curr = next;

Now:

prev curr
↓ ↓
1 → null 2 → 3 → 4

We are ready to reverse the next node.

---

# 9. The Four-Step Cycle

Every iteration performs exactly four operations:
java
ListNode next = curr.next;

curr.next = prev;

prev = curr;
curr = next;

Think:

SAVE
↓
REVERSE
↓
MOVE PREV
↓
MOVE CURR

Or simply:

> **Save → Reverse → Advance**

The order matters.

---

# 10. Full Dry Run

Starting list:

1 → 2 → 3 → 4 → null

### Iteration 1

Reverse `1`:

prev:
1 → null

curr:
2 → 3 → 4

### Iteration 2

Reverse `2`:

prev:
2 → 1 → null

curr:
3 → 4

### Iteration 3

Reverse `3`:

prev:
3 → 2 → 1 → null

curr:
4

### Iteration 4

Reverse `4`:

prev:
4 → 3 → 2 → 1 → null

curr:
null

The loop stops.

Therefore:
java
return prev;

---

# 11. Why Does `prev` Become the New Head?

At the end:

prev
↓
4 → 3 → 2 → 1 → null

curr
↓
null

The old head was:

1

After reversal, `1` becomes the tail.

The new head is:

4

And `prev` points to `4`.

Therefore:
java
return prev;

---

# 12. The Most Important Invariant

At the beginning of every iteration:

prev
↓
Already Reversed

and

curr
↓
First Unreversed Node

while:

next
↓
Remaining Unreversed List

So conceptually:

        Reversed          Unreversed
           ↓                  ↓

prev → [already done] curr → [remaining]

                         next preserves
                         the remaining list

This invariant is more important than memorizing the code.

---

# 13. Full Reverse Template

java
ListNode prev = null;
ListNode curr = head;

while (curr != null) {

    ListNode next = curr.next;

    curr.next = prev;

    prev = curr;
    curr = next;

}

return prev;

---

# 14. Pointer Responsibility

| Pointer | Meaning                      |
| ------- | ---------------------------- |
| `prev`  | Reversed portion             |
| `curr`  | Current node                 |
| `next`  | Remaining unreversed portion |

Remember:

prev → already reversed

curr → currently processing

next → don't lose the rest

---

# 15. Why `next` Is Necessary

Without:
java
ListNode next = curr.next;

we would lose access to the remaining list after doing:
java
curr.next = prev;

Therefore:

> **`next` protects the part of the list that has not been processed yet.**

This is the most important reason for the third pointer.

---

# 16. Complexity

For a list of `n` nodes:

### Time

Every node is processed exactly once.

O(n)

### Extra Space

Only three pointers are used.

O(1)

So:

Time = O(n)
Space = O(1)

---

# 17. Pattern 2 Roadmap

The entire reversal family is built from the same three-pointer mechanism.

Pattern 2 — Reversal
│
├── Level 1
│ └── Full Reverse
│ └── 206. Reverse Linked List
│
├── Level 2
│ └── Reverse Between
│ └── 92. Reverse Linked List II
│
├── Level 3
│ └── Reverse in K Groups
│ └── 25. Reverse Nodes in k-Group
│
├── Level 4
│ └── Reverse Alternate K Groups
│
└── Level 5
└── Reverse for Palindrome
└── 234. Palindrome Linked List

---

# 18. How the Difficulty Evolves

## Level 1 — Full Reverse

Reverse:

1 → 2 → 3 → 4

into:

4 → 3 → 2 → 1

The entire list is reversed.

Main skill:

prev + curr + next

---

## Level 2 — Reverse Between

Only reverse:

left → right

Example:

1 → 2 → 3 → 4 → 5

Reverse positions `2` through `4`:

1 → 4 → 3 → 2 → 5

Now the challenge is not reversal itself.

The challenge is:

> **Connect the reversed section back to the untouched parts.**

---

## Level 3 — Reverse in K Groups

Example:

1 → 2 → 3 → 4 → 5 → 6

For:

k = 2

reverse:

1 → 2
3 → 4
5 → 6

Result:

2 → 1 → 4 → 3 → 6 → 5

The key question becomes:

> **Do I have `k` nodes available before reversing?**

---

## Level 4 — Reverse Alternate K Groups

Now we combine:

reverse

- skip
- reverse
- skip

Example:

[k nodes] [k nodes] [k nodes]

Reverse one group, leave the next group unchanged, and continue.

---

## Level 5 — Reverse for Palindrome

Example:

1 → 2 → 2 → 1

We combine:

Fast & Slow

- Reverse
- Compare

The process becomes:

Find middle
↓
Reverse second half
↓
Compare both halves

This demonstrates an important idea:

> **Hard problems are often combinations of patterns you already know.**

---

# 19. Pattern Recognition

When you see:

- Reverse linked list
- Reverse a section
- Reverse between positions
- Reverse every `k` nodes
- Reverse alternate groups
- Reverse the second half
- Compare first and second half after reversal

Think:

REVERSE
↓
prev / curr / next

Then ask:

> **Which arrows need to change, and what connections must I save before changing them?**

---

# 20. Common Mistakes

### Mistake 1 — Changing `curr.next` before saving it

Wrong:
java
curr.next = prev;
next = curr.next;

Now `next` no longer points to the original next node.

Correct:
java
next = curr.next;
curr.next = prev;

---

### Mistake 2 — Returning `head`

After reversal, the old `head` is the tail.

Return:
java
return prev;

---

### Mistake 3 — Moving `curr` incorrectly

Correct:
java
curr = next;

Not:
java
curr = curr.next;

because `curr.next` has already been changed.

---

### Mistake 4 — Losing the remaining list

The purpose of:
java
next = curr.next;

is to protect the unreversed portion before changing the arrow.

---

# 21. Golden Rule

The entire Pattern 2 begins with one rule:

> **Before changing an arrow, save where that arrow originally pointed.**

Then:

Save
↓
Reverse
↓
Advance

---

# One-Line Memory Trick

**`prev` = reversed, `curr` = current, `next` = remaining.**

next = curr.next;
curr.next = prev;
prev = curr;
curr = next;

Understand the **meaning of the three pointers**, and the complete Linked List Reversal family becomes much easier to derive.
