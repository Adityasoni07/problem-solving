Pattern 5 — Two-Pointer Distance

Pattern 5 — Two-Pointer Distance
│
├── 1. Remove Nth Node From End
├── 2. Kth Node From End
├── 3. Intersection of Two Linked Lists
└── 4. Fixed Distance Between Pointers

The core technique is:

fast
↓
? nodes ahead
↓
slow

Then move both together.

Because their distance stays constant, when one pointer reaches a meaningful position, the other pointer is automatically at the position we want.

1. Why Do We Need This Pattern?

Consider:

1 → 2 → 3 → 4 → 5

Suppose I ask:

Find the 2nd node from the end.

Answer:

1 → 2 → 3 → 4 → 5
↑
4

A straightforward solution:

First traversal

Find length:

n = 5

Then:

index = n - k
= 5 - 2
= 3

Second traversal gets node 4.

This works.

But can we do it in one traversal?

Yes.

That's why the two-pointer distance technique exists.

2. The Core Idea

We create:

slow
fast

and intentionally make:

distance(fast, slow) = k

For example:

1 → 2 → 3 → 4 → 5
↑ ↑
slow fast

If the distance is maintained, when fast reaches the end:

1 → 2 → 3 → 4 → 5 → null
↑
slow

slow is automatically at the required position.

3. The Invariant ⭐

This is what I want you to remember.

The distance between fast and slow remains constant after both pointers start moving together.

For example:

distance = 2

Then:

Before:
slow → 1
fast → 3

After:
slow → 2
fast → 4

After:
slow → 3
fast → 5

Distance is always:

2

That's the entire pattern.

4. How Do We Create the Distance?

Suppose:

1 → 2 → 3 → 4 → 5

We want:

fast
↓
3

slow
↓
1

Distance = 2.

We can simply move fast two times first:

fast = fast.next;
fast = fast.next;

Then:

slow → 1
fast → 3

Now move both one step at a time:

slow = slow.next;
fast = fast.next;

The distance remains 2.

5. Remove Nth Node From End
   LeetCode 19

Consider:

1 → 2 → 3 → 4 → 5

Remove:

2nd from end

Answer:

1 → 2 → 3 → 5

The node to delete is:

4

But to delete a node in a singly linked list, we need its previous node:

3 → 4 → 5
↑ ↑
prev target

So our real goal becomes:

Position slow at the node before the target.

This is where the dummy node becomes useful.

6. Why Dummy + Two Pointers?

Create:

dummy → 1 → 2 → 3 → 4 → 5

Start:

slow = dummy
fast = dummy

Now move fast n steps.

For:

n = 2

we get:

dummy → 1 → 2 → 3 → 4 → 5
↑ ↑
slow fast

Then move both until:

fast == null

At that point:

dummy → 1 → 2 → 3 → 4 → 5
↑
slow

slow is at 3.

And:

slow.next

is the node we need to remove:

3 → 4 → 5
↑
delete

So:

slow.next = slow.next.next;

Result:

1 → 2 → 3 → 5

Beautiful combination:

Two-Pointer Distance +
Dummy Node 7. Why the Dummy Node Matters Here

What if we remove the first node?

1 → 2 → 3

and:

n = 3

Without dummy, the head is the node being removed.

Special case.

With dummy:

dummy → 1 → 2 → 3

The node before 1 is simply:

dummy

So:

slow.next = slow.next.next;

works even when removing the original head.

Again, this is exactly why we learned Pattern 4.

8. Kth Node From End

This is essentially the same pattern without deleting anything.

Given:

1 → 2 → 3 → 4 → 5

Find the:

2nd node from end

We create distance:

slow → 1
fast → 3

Then move together:

slow → 2
fast → 4

Then:

slow → 3
fast → 5

Then fast reaches null.

Depending on exactly how we initialize the pointers, slow can represent either:

kth node from end, or
node before kth node.

This is an important interview detail:

The pointer initialization determines the position you get.

Don't blindly memorize a loop.

9. Distance Between Pointers

This is the general abstraction.

Suppose:

A → B → C → D → E → F

and:

slow → B
fast → E

Then:

distance = 3

If both move:

slow → C
fast → F

Distance is still:

3

Therefore:

If two pointers start with a known separation and move at the same speed, that separation is preserved.

This is the mathematical foundation.

10. Intersection of Two Linked Lists
    LeetCode 160

This one looks completely different.

List A:

      1 → 2
           \
            8 → 9
           /
      3 → 4

More accurately:

A: 1 → 2 → 8 → 9
↑
B: 3 → 4 ┘

The two lists share the same nodes from 8 onward.

We want:

8 11. The Problem

The lists may have different lengths.

Example:

A:

1 → 2 → 3 → 8 → 9
↑
└──── shared

B:

4 → 5 → 8 → 9

If we simply start:

a = headA
b = headB

they won't reach the shared portion at the same time.

Because:

length(A) ≠ length(B)

So we need to eliminate the length difference.

12. The Elegant Trick

When pointer a reaches the end of List A:

a = headB;

When pointer b reaches the end of List B:

b = headA;

So they switch lists.

Why?

Because this causes both pointers to travel the same total distance.

Suppose:

length A = 5
length B = 3

Pointer A travels:

A + B = 8

Pointer B travels:

B + A = 8

Therefore the length difference disappears.

Eventually:

a == b

at the intersection.

13. The Important Insight

This isn't really about:

"switch heads because that's the trick."

It's about:

Equalizing the total distance traveled by both pointers.

This is the same fundamental idea as the entire pattern.

Different starting positions
↓
Create equal effective distance
↓
Move together
↓
Relative position becomes useful 14. Pattern 1 vs Pattern 5

This distinction is important.

Pattern 1 — Fast & Slow
slow += 1
fast += 2

Purpose:

middle
cycle
cycle entry

Core idea:

Different speeds.

Pattern 5 — Two-Pointer Distance
slow += 1
fast += 1

but initially:

distance(slow, fast) = k

Purpose:

kth from end
remove nth
relative position

Core idea:

Same speed + controlled distance.

15. Pattern Recognition

When you see:

"Kth from the end"

Immediately think:

fast → move k steps ahead
slow → follow
"Remove Nth from the end"

Think:

dummy

- fast/slow distance
  "Intersection of two linked lists"

Think:

pointer A → switch to B
pointer B → switch to A
"Keep two pointers a fixed distance apart"

Think:

Two-Pointer Distance 16. Core Template

For kth-from-end style problems:

ListNode slow = head;
ListNode fast = head;

// Create distance
for (int i = 0; i < k; i++) {
fast = fast.next;
}

// Maintain distance
while (fast != null) {
slow = slow.next;
fast = fast.next;
}

At the end:

slow = kth node from the end

If you need the previous node, start from a dummy:

ListNode dummy = new ListNode(0);
dummy.next = head;

ListNode slow = dummy;
ListNode fast = dummy;

Then choose the initial distance carefully.

17. Problems to Master

For this pattern, I'd use:

Order LeetCode Problem Core Idea
1 19 Remove Nth Node From End Fixed distance + dummy
2 160 Intersection of Two Linked Lists Equalize total distance
3 1721 Swapping Nodes in a Linked List Kth from beginning/end
4 2095 Delete the Middle Node Two-pointer positioning

For pure pattern mastery, 19 and 160 are the two most important.

Pattern 5 Mental Model

Reduce everything to this:

                TWO POINTER DISTANCE


                      ↓


              Establish a distance
                      ↓
             ┌────────┴────────┐
             ↓                 ↓
        Move together      Equalize paths
             ↓                 ↓
      kth / nth position   Intersection

The sentence I want you to remember is:

Fast & Slow uses different speeds; Two-Pointer Distance uses the same speed but starts with a meaningful distance.

That distinction will prevent you from mixing Pattern 1 and Pattern 5 when you start solving problems.
