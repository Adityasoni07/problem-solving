Pattern 4 — Dummy Node Pattern
Pattern 4 — Dummy Node
│
├── 1. Core Dummy Node Technique
│
├── 2. Remove Nodes
│
├── 3. Delete Duplicates
│
├── 4. Partition
│
├── 5. Odd Even
│
├── 6. Rotate
│
└── 7. Insertion Operations

1. What Is the Dummy Node Pattern?

A dummy node is an artificial node placed before the real head of a linked list.

Example:

Original:

1 → 2 → 3 → 4 → null

With a dummy:

dummy → 1 → 2 → 3 → 4 → null

The dummy node is not part of the actual answer.

Its purpose is to simplify operations involving the head.

One-line definition

Dummy Node = Create an artificial node before the head so head-related operations become normal linked-list operations.

2. What Problem Does Dummy Node Solve?

Consider:

1 → 2 → 3 → 4

Suppose we want to remove 1.

Because 1 is the head, we need:

head = head.next;

But if we want to remove 2, we need:

prev.next = curr.next;

So without a dummy node, we have two different cases:

Delete head
↓
Modify head

Delete normal node
↓
Modify prev.next

This creates unnecessary edge cases.

3. The Dummy Node Idea

Add an artificial node:

dummy → 1 → 2 → 3 → 4

Now even the original head has a previous node:

dummy → 1
↑
previous

Therefore, deleting 1 becomes exactly the same as deleting any other node.

prev.next = curr.next;

After deleting 1:

dummy → 2 → 3 → 4

Finally:

head = dummy.next;

gives:

2 → 3 → 4 4. The Core Idea

The real purpose of a dummy node is:

Boundary Problem
↓
Create Artificial Boundary
↓
Every real node has a predecessor
↓
Same operation works everywhere

This is the most important thing to understand.

Don't think:

"Dummy node is something I always create."

Think:

"Can the head itself be modified? If yes, can I create a node before it to eliminate the special case?"

5. Why Is It So Powerful?

Without dummy:

head → 1 → 2 → 3

Node 1 has no predecessor.

With dummy:

dummy → 1 → 2 → 3

Now:

dummy → 1
↑
prev

So every real node has:

previous → current

That gives us one universal operation:

prev.next = curr.next;

Whether curr is:

head

or:

middle

or:

tail

the operation is the same.

6. The Core Invariant

A common setup is:

ListNode dummy = new ListNode(0);
dummy.next = head;

ListNode prev = dummy;
ListNode curr = head;

The meaning is:

prev → node before curr

curr → current node being examined

Visual:

dummy → 1 → 2 → 3 → 4
↑ ↑
prev curr

The invariant is:

prev always points to the node immediately before curr.

7. Core Delete Operation

Suppose:

dummy → 1 → 2 → 3
↑ ↑
prev curr

We want to delete 2.

Simply do:

prev.next = curr.next;

Result:

dummy → 1 → 3

No special handling is required.

8. What If curr Is the Head?

Suppose:

dummy → 1 → 2 → 3
↑ ↑
prev curr

Again:

prev.next = curr.next;

Result:

dummy → 2 → 3

Then:

head = dummy.next;

Result:

2 → 3

This is the main reason dummy nodes are useful.

9. Why dummy.next Is the New Head

Initially:

dummy → originalHead

During the algorithm, the real head may change.

But the dummy remains fixed:

dummy → newHead

Therefore:

return dummy.next;

returns the current real head.

Important

The dummy itself should never be returned.

Wrong:

return dummy;

Correct:

return dummy.next; 10. Universal Modification Template

A common pattern is:

ListNode dummy = new ListNode(0);
dummy.next = head;

ListNode prev = dummy;
ListNode curr = head;

while (curr != null) {

    if (/* remove curr */) {

        prev.next = curr.next;
        curr = curr.next;

    } else {

        prev = curr;
        curr = curr.next;
    }

}

return dummy.next;

The important invariant:

dummy → ... → prev → curr → ...

prev is always the node before curr.

11. Dummy Node vs Sentinel Node

You may see both names:

Dummy Node
Sentinel Node

In linked-list problems, they generally refer to the same idea:

An artificial node used to simplify boundary conditions.

Example:

dummy → head

The dummy's value usually doesn't matter:

new ListNode(0)

The 0 is not part of the answer.

12. Pattern 4 Variations
1. Remove Nodes
   LeetCode 203 — Remove Linked List Elements

Example:

6 → 1 → 6 → 2 → 6

Remove 6.

Result:

1 → 2

Dummy node is useful because the first node may also need to be removed.

The same operation handles:

head
middle
tail 13. Delete Duplicates
LeetCode 83 — Remove Duplicates from Sorted List

Example:

1 → 1 → 2 → 3 → 3

Result:

1 → 2 → 3

The core operation is:

curr.next = curr.next.next;

A dummy node is not strictly necessary here.

This is important:

A technique can be useful without being mandatory.

Don't force a dummy node into every linked-list problem.

14. Delete All Duplicates
    LeetCode 82 — Remove Duplicates from Sorted List II

Example:

1 → 2 → 2 → 3 → 4 → 4

Result:

1 → 3

Here all copies of duplicated values must be removed.

A dummy node is particularly useful because the duplicated group may start at the head.

Example:

dummy → 1 → 1 → 2 → 3

If the first group is duplicated, the dummy allows us to remove the entire group using the same connection logic.

15. Partition
    LeetCode 86 — Partition List

Given:

1 → 4 → 3 → 2 → 5 → 2

and:

x = 3

we want:

1 → 2 → 2 → 4 → 3 → 5

The idea is to build two separate chains.

Smaller values
lessDummy → 1 → 2 → 2
Greater/equal values
greaterDummy → 4 → 3 → 5

Then connect them:

lessTail.next = greaterDummy.next;

The dummy nodes act as anchors for constructing the two lists.

This gives us another important use of dummy nodes:

Dummy nodes make building new linked-list chains easier.

16. Multiple Dummy Nodes

Dummy nodes are not limited to one.

For partitioning:

lessDummy
greaterDummy

We maintain:

lessDummy → smaller nodes

greaterDummy → greater/equal nodes

At the end:

lessTail.next = greaterDummy.next;

and return:

lessDummy.next;

Mental model:

             Original List
                   ↓
            ┌──────┴──────┐
            ↓             ↓
       Smaller        Greater/Equal
            ↓             ↓
       lessDummy     greaterDummy
            ↓             ↓
          list A         list B
            └──────┬──────┘
                   ↓
                 Merge

17. Odd Even
    LeetCode 328 — Odd Even Linked List

Given:

1 → 2 → 3 → 4 → 5

Result:

1 → 3 → 5 → 2 → 4

Conceptually:

Odd:

1 → 3 → 5

Even:

2 → 4

Then connect:

oddTail.next = evenHead;

A dummy node can be used, but the standard solution does not require one.

So this is better classified as:

Pointer Manipulation

rather than a pure Dummy Node problem.

18. Rotate
    LeetCode 61 — Rotate List

Example:

1 → 2 → 3 → 4 → 5

Rotate right by 2:

4 → 5 → 1 → 2 → 3

The main ideas are:

Find length
↓
Connect tail to head
↓
Create a circle
↓
Find new tail
↓
Break the circle

A dummy node is not the core technique.

Therefore:

Rotate List should not be considered a pure Dummy Node problem.

This is important when building a clean pattern library.

19. Insertion Operations

Dummy nodes are also useful when inserting nodes near the head.

Suppose:

1 → 3

Insert 2:

1 → 2 → 3

Normally:

newNode.next = prev.next;
prev.next = newNode;

But what if we want to insert before the head?

Without dummy:

newNode.next = head;
head = newNode;

That's another special case.

With dummy:

dummy → 1 → 3

Insert after dummy:

dummy → newNode → 1 → 3

Now the insertion uses the same logic.

Therefore:

Dummy nodes turn insertion at the head into ordinary insertion.

20. When Should You Think of Dummy Node?

Ask yourself:

Could the head itself be modified?

For example:

delete head
insert before head
replace head
remove a group starting at head

If yes:

Think → Dummy Node
Are you constructing a new linked-list chain?

For example:

partition
merge
split into multiple chains

A dummy node may make construction easier.

21. When Should You NOT Force a Dummy Node?

Dummy nodes are a technique, not a requirement.

Don't use one just because you're solving a linked-list problem.

For example:

Reverse Linked List

The core technique is:

prev + curr + next

not dummy node.

Similarly:

Rotate List

is primarily:

length + circular connection + break

Therefore:

First identify the actual algorithmic pattern. Then use a dummy node if it simplifies the boundary cases.

22. Without Dummy vs With Dummy
    Without Dummy
    head → 1 → 2 → 3

Delete 1:

head = head.next;

Delete 2:

prev.next = curr.next;

Two different cases.

With Dummy
dummy → 1 → 2 → 3

Delete 1:

prev.next = curr.next;

Delete 2:

prev.next = curr.next;

Delete 3:

prev.next = curr.next;

One operation works everywhere.

That is the entire advantage.

23. Core Mental Model

Don't remember:

ListNode dummy = new ListNode(0);

as a magic line.

Remember:

Problem at boundary
↓
Add artificial boundary
↓
Remove special case
↓
Use one universal operation

This is the real Dummy Node Pattern.

24. Common Mistakes
    Mistake 1 — Returning dummy

Wrong:

return dummy;

Correct:

return dummy.next;
Mistake 2 — Forgetting to connect dummy

Wrong:

ListNode dummy = new ListNode(0);

Correct:

ListNode dummy = new ListNode(0);
dummy.next = head;
Mistake 3 — Moving prev after deletion

Suppose:

dummy → 1 → 2 → 3
↑ ↑
prev curr

Delete 2.

Do:

prev.next = curr.next;
curr = curr.next;

Do not move prev.

Why?

Because after deletion:

dummy → 1 → 3
↑
prev

prev is still the node before the new curr.

Mistake 4 — Using Dummy Everywhere

Dummy nodes are optional.

The correct question is:

Does a dummy node simplify a boundary case in this problem?

If yes, use it.

If not, don't force it.

25. Pattern Recognition Cheat Sheet
    Problem Type Dummy Node
    Remove nodes ⭐⭐⭐⭐⭐
    Delete groups ⭐⭐⭐⭐⭐
    Insert before head ⭐⭐⭐⭐⭐
    Partition into lists ⭐⭐⭐⭐⭐
    Merge lists ⭐⭐⭐⭐⭐
    Delete duplicates ⭐⭐⭐⭐
    Odd-Even rearrangement ⭐⭐
    Rotate list ⭐
    Reverse list ⭐

The stars indicate how naturally the technique fits the problem, not how difficult the problem is.

26. Pattern 4 Roadmap
    Pattern 4 — Dummy Node
    │
    ├── Core Technique
    │ └── Artificial node before head
    │
    ├── Remove Nodes
    │ └── 203. Remove Linked List Elements
    │
    ├── Delete Duplicates
    │ ├── 83. Remove Duplicates from Sorted List
    │ └── 82. Remove Duplicates from Sorted List II
    │
    ├── Partition
    │ └── 86. Partition List
    │
    ├── Odd Even
    │ └── 328. Odd Even Linked List
    │
    ├── Rotate
    │ └── 61. Rotate List
    │
    └── Insertion
    └── Various linked-list insertion problems

Important classification:

Pure Dummy Node Core
↓
Boundary simplification

Other linked-list patterns
↓
May use Dummy Node as a helper 27. Pattern 4 Master Invariant

The most important invariant is:

dummy is a permanent node before the real list, and prev points to the node immediately before curr.

Visual:

dummy → ... → prev → curr → ...

This allows operations such as:

prev.next = curr.next;

to work even when curr is the original head.

28. Golden Rule

When a linked-list operation may modify the head, create a dummy node before the head to eliminate the special case.

The deeper idea is:

Boundary case
↓
Artificial boundary
↓
Same operation everywhere
One-line memory trick

Dummy Node = Add a node before the head so the head stops being special.

That is the core of Pattern 4.
