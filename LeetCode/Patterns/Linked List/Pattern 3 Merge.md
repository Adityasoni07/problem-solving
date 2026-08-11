# Pattern 3 — Merge

Pattern 3 — Merge
│
├── 1. Merge Two Sorted Lists
├── 2. Merge K Sorted Lists
├── 3. Split + Merge
└── 4. Sort List

Before learning these variations, we first need to understand the **core merge operation**.

> **Given multiple sorted linked-list portions, repeatedly choose the smallest current node and connect it to the result.**

---

# 1. What Does "Merge" Mean?

Suppose we have two sorted linked lists:

List A:
1 → 4 → 7

List B:
2 → 3 → 8

We want:

1 → 2 → 3 → 4 → 7 → 8

The important point is:

> **We do not need to create new nodes.**

The nodes already exist.

We only change their `next` connections to build the final sorted list.

This connects to the fundamental linked-list idea:

> **Linked-list algorithms are primarily about changing arrows.**

---

# 2. The Key Observation

Because both lists are sorted:

A:
1 → 4 → 7

B:
2 → 3 → 8

At any moment, we only need to compare:

A's current node
B's current node

Why?

Suppose:

A:
4 → 7

Since A is sorted, everything after `4` is greater than or equal to `4`.

Similarly:

B:
2 → 3 → 8

Everything after `2` is greater than or equal to `2`.

Therefore:

> **The smallest remaining node must be one of the two current nodes.**

This is the fundamental property that makes merging possible.

---

# 3. The Merge Invariant

This is the most important concept in the Merge Pattern.

At every iteration:

result
↓
already merged nodes

a → remaining nodes of List A

b → remaining nodes of List B

The invariant is:

> **`result` contains the smallest remaining nodes selected so far, in sorted order.**

Therefore, every iteration asks:

Is a.val <= b.val?

YES → take a

NO → take b

After choosing a node:

connect it to result
move that list's pointer forward
move tail forward

---

# 4. Why Do We Use a Dummy Node?

Without a dummy node, we would need special handling for the first node.

For example:

ListNode head = null;
ListNode tail = null;

Then we would have to write:

if (head == null) {
head = chosen;
tail = chosen;
} else {
tail.next = chosen;
tail = tail.next;
}

This creates unnecessary complexity.

Instead, create:

dummy → null
↑
tail

Now every insertion works exactly the same way:

tail.next = chosen;
tail = tail.next;

At the end:

return dummy.next;

The dummy node is not part of the actual answer.

It is simply a permanent starting point that makes the pointer logic easier.

---

# 5. Visual Derivation

Suppose:

A
↓
1 → 4 → 7

B
↓
2 → 3 → 8

Create:

dummy → null
↑
tail

---

## Step 1

Compare:

1 vs 2

Choose `1`.

dummy → 1

A → 4 → 7

B → 2 → 3 → 8

Move:

tail → 1
A → 4

---

## Step 2

Compare:

4 vs 2

Choose `2`.

dummy → 1 → 2

A → 4 → 7

B → 3 → 8

Move:

tail → 2
B → 3

---

## Step 3

Compare:

4 vs 3

Choose `3`.

dummy → 1 → 2 → 3

A → 4 → 7

B → 8

---

## Step 4

Compare:

4 vs 8

Choose `4`.

dummy → 1 → 2 → 3 → 4

A → 7

B → 8

---

## Step 5

Compare:

7 vs 8

Choose `7`.

dummy → 1 → 2 → 3 → 4 → 7

A → null

B → 8

---

## Step 6 — One List Is Empty

A is finished.

There is no reason to compare anymore.

Simply attach the remaining part:

tail.next = b;

Result:

1 → 2 → 3 → 4 → 7 → 8

---

# 6. The Three Important References

The Merge Pattern mainly uses:

a
b
tail

Their meanings are:

a
↓
current node in List A

b
↓
current node in List B

tail
↓
last node in merged result

We also use:

dummy
↓
permanent beginning of the result

So the mental model is:

dummy
↓
result → result → result → tail

a → remaining A

b → remaining B

---

# 7. The Core Merge Operation

The essential operation is:

if (a.val <= b.val) {
tail.next = a;
a = a.next;
} else {
tail.next = b;
b = b.next;
}

tail = tail.next;

Think:

COMPARE
↓
CHOOSE
↓
CONNECT
↓
ADVANCE

This is the core cycle of the Merge Pattern.

---

# 8. Universal Template

ListNode dummy = new ListNode(0);
ListNode tail = dummy;

while (a != null && b != null) {

    if (a.val <= b.val) {
        tail.next = a;
        a = a.next;
    } else {
        tail.next = b;
        b = b.next;
    }

    tail = tail.next;

}

if (a != null) {
tail.next = a;
} else {
tail.next = b;
}

return dummy.next;

Don't memorize this blindly.

Understand what each pointer represents.

---

# 9. Why Don't We Need `next` Here?

This is an important difference between **Reversal** and **Merge**.

In reversal, we do:

curr.next = prev;

This destroys the original connection.

Therefore we must first save:

next = curr.next;

But in merging, we are not destroying the remaining connection of `a` or `b`.

Suppose:

a:

4 → 7 → 9

We do:

tail.next = a;

Now:

result → 4 → 7 → 9

The connection:

4 → 7 → 9

still exists.

Then:

a = a.next;

moves `a` to `7`.

So no separate `next` pointer is necessary.

---

# 10. Why Is the Merge Correct?

Suppose:

A = 5 → 10 → 20

B = 3 → 7 → 30

Current nodes:

a = 5
b = 3

The smallest remaining value must be `3`.

Why?

Because:

All remaining A values >= 5

and:

All remaining B values >= 3

Therefore `3` is definitely the smallest remaining node.

Choose `3`.

Now:

A = 5 → 10 → 20

B = 7 → 30

Compare:

5 vs 7

Choose `5`.

Then:

10 vs 7

Choose `7`.

And so on.

The same reasoning continues at every step.

Therefore:

> **Every time we choose the smallest current node, the resulting list remains sorted.**

---

# 11. Complexity

Suppose:

List A has m nodes
List B has n nodes

Every node is processed exactly once.

Therefore:

Time = O(m + n)

We reuse the existing nodes.

No new list containing all `m + n` nodes is created.

Therefore:

Extra Space = O(1)

So:

Time = O(m + n)
Space = O(1)

---

# 12. Pattern 3 Roadmap

The entire Merge Pattern grows from the basic two-list merge.

Pattern 3 — Merge
│
├── Level 1
│ └── Merge Two Sorted Lists
│ └── 21. Merge Two Sorted Lists
│
├── Level 2
│ └── Merge K Sorted Lists
│ └── 23. Merge k Sorted Lists
│
├── Level 3
│ └── Split + Merge
│
└── Level 4
└── Sort List
└── 148. Sort List

---

# 13. Level 1 — Merge Two Sorted Lists

### LeetCode 21

Example:

A:
1 → 4 → 7

B:
2 → 3 → 8

Result:

1 → 2 → 3 → 4 → 7 → 8

Core skill:

Two current pointers

- Tail pointer
- Dummy node

This is the foundation of the entire pattern.

You should be able to write this without looking at the template.

---

# 14. Level 2 — Merge K Sorted Lists

### LeetCode 23

Now suppose we have:

L1: 1 → 4 → 7

L2: 2 → 5 → 8

L3: 0 → 3 → 9

We want:

0 → 1 → 2 → 3 → 4 → 5 → 7 → 8 → 9

The merge idea remains the same.

The difference is:

> **Instead of two current nodes, we now have K current nodes.**

There are multiple approaches.

---

## Approach A — Sequential Merge

First:

merge(L1, L2)

Then:

merge(result, L3)

Then:

merge(result, L4)

And so on.

Conceptually:

L1 + L2
↓
result

result + L3
↓
result

result + L4
↓
result

This is simple but can be inefficient because the growing result may be merged repeatedly.

---

## Approach B — Min Heap

Keep the smallest current node from every list inside a min heap.

Example:

L1: 1 → 4 → 7
L2: 2 → 5 → 8
L3: 0 → 3 → 9

Initially the heap contains:

1
2
0

The smallest is:

0

Take `0`.

Then insert the next node from its list:

3

Now repeat.

The heap always tells us:

> **Which list currently contains the globally smallest available node?**

Complexity:

O(N log K)

where:

N = total number of nodes
K = number of lists

---

# 15. Level 3 — Split + Merge

Now consider an unsorted linked list:

4 → 2 → 1 → 3

We cannot directly merge it because it is not already sorted.

Instead:

SPLIT
↓
4 → 2 1 → 3

Sort both parts:

2 → 4 1 → 3

Then:

MERGE
↓

1 → 2 → 3 → 4

This creates the foundation of **Merge Sort**.

---

# 16. How Do We Split a Linked List?

This connects to the **Fast & Slow Pointer Pattern**.

Use:

slow
fast

Example:

1 → 2 → 3 → 4 → 5

Move:

slow → one step
fast → two steps

When `fast` reaches the end, `slow` is around the middle.

Therefore:

Fast & Slow
↓
Find middle
↓
Split
↓
Merge

This is an important example of combining patterns.

---

# 17. Level 4 — Sort List

### LeetCode 148

The overall structure becomes:

Unsorted List
↓
Split
/ \
 Left Right
↓ ↓
Sort Sort
↓ ↓
\ /
Merge
↓
Sorted List

Conceptually:

Fast & Slow
↓
Split
↓
Recursive Sort
↓
Merge

Therefore, `Sort List` is not a completely new pattern.

It is a combination of:

Fast & Slow

- Recursion
- Merge

  ***

# 18. Pattern 3 Mental Model

The entire Merge Pattern can be reduced to:

Multiple sorted streams
↓
Compare current nodes
↓
Choose smallest
↓
Attach to result
↓
Advance chosen stream
↓
Repeat

The key word is:

> **Sorted.**

If the input portions are already sorted, merging becomes very efficient because we only need to inspect their current nodes.

---

# 19. Pattern Recognition

When you see:

### "Merge two sorted linked lists"

Think:

Two pointers

- Tail
- Dummy node

  ***

### "Merge K sorted lists"

Think:

Multiple sorted streams +
Min Heap

or:

Divide and Conquer +
Merge

---

### "Sort a linked list"

Think:

Fast & Slow
↓
Split
↓
Sort halves
↓
Merge

---

# 20. Common Mistakes

## Mistake 1 — Forgetting to move `tail`

Wrong:

tail.next = a;

Correct:

tail.next = a;
tail = tail.next;

Otherwise, the next node will overwrite the same position.

---

## Mistake 2 — Forgetting to move `a` or `b`

After choosing `a`:

tail.next = a;
a = a.next;

After choosing `b`:

tail.next = b;
b = b.next;

Otherwise, you repeatedly process the same node.

---

## Mistake 3 — Forgetting the remaining list

The loop stops when:

a == null

or:

b == null

But the other list may still contain nodes.

So attach the remainder:

if (a != null)
tail.next = a;
else
tail.next = b;

---

## Mistake 4 — Returning `dummy`

Wrong:

return dummy;

The dummy node is not part of the actual answer.

Correct:

return dummy.next;

---

## Mistake 5 — Creating unnecessary new nodes

Usually we can reuse the existing nodes.

The merge operation only needs to reconnect them.

---

# 21. Merge vs Reversal

This difference is important because both patterns modify linked-list pointers.

| Reversal                             | Merge                                            |
| ------------------------------------ | ------------------------------------------------ |
| Changes arrow direction              | Connects existing nodes                          |
| `prev` is essential                  | `tail` is essential                              |
| Uses `prev`, `curr`, `next`          | Uses `a`, `b`, `tail`                            |
| Must save `next`                     | Usually no separate `next` needed                |
| Goal: reverse order                  | Goal: preserve sorted order                      |
| Core cycle: Save → Reverse → Advance | Core cycle: Compare → Choose → Connect → Advance |

The mental models are different.

### Reversal

Which arrow should point backward?

### Merge

Which current node is smaller?

---

# 22. Pattern 3 Master Invariant

The most important invariant to remember is:

> **At every step, `tail` is the last node of the correctly sorted result, while `a` and `b` point to the smallest not-yet-merged nodes of their respective lists.**

Visually:

Already Sorted Result
↓
dummy → ... → tail

              ↓
              a → remaining A

              ↓
              b → remaining B

Every iteration:

Compare a and b
↓
Pick smaller
↓
Attach after tail
↓
Advance chosen pointer
↓
Advance tail

---

# 23. Golden Rule

> **When multiple linked-list portions are sorted, repeatedly take the smallest current node and attach it to the result.**

Remember the core cycle:

COMPARE
↓
CHOOSE
↓
CONNECT
↓
ADVANCE

Once this becomes automatic:

Merge Two
↓
Merge K
↓
Split + Merge
↓
Sort List

becomes one connected pattern instead of four unrelated problems.
