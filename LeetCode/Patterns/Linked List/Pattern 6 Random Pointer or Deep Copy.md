Pattern 6 — Random Pointer / Deep Copy

This is a specialized Linked List pattern, but it's very important because it tests something deeper than normal linked-list manipulation:

Can you preserve relationships between objects while creating completely new objects?

The classic problem is:

LeetCode 138 — Copy List with Random Pointer

We'll build this from the foundation we've already learned: references, objects, and pointer manipulation.

1. Normal Linked List vs Random Pointer List

Normal linked list:

1 → 2 → 3 → 4

Each node has:

class Node {
int val;
Node next;
}

So each node has one relationship:

Node → next Node

With a random pointer:

class Node {
int val;
Node next;
Node random;
}

Now every node has two independent relationships:

        next

Node ──────────→ Node

        random

Node ──────────→ ANY Node

The random pointer can point:

to itself
to another node
backward
forward
or null

Example:

1 → 2 → 3 → 4

Random pointers might be:

1.random → 3
2.random → 1
3.random → 4
4.random → 2 2. What Does "Copy" Actually Mean?

This is where the problem becomes interesting.

Suppose original list is:

Original:

A → B → C

We need:

Copy:

A' → B' → C'

The copied nodes must be different objects.

So:

A != A'
B != B'
C != C'

But their relationships must be identical.

For example:

Original:

A.random → C

must become:

Copy:

A'.random → C'

NOT:

A'.random → C

That's the entire challenge.

3. Shallow Copy vs Deep Copy

This distinction is critical.

Shallow Copy

Imagine:

Original Node A
|
└────random────→ Original Node C

A shallow copy might produce:

Copy A'
|
└────random────→ Original C

The copy still points into the original structure.

That's usually wrong.

Deep Copy

We need:

Original:

A ─────→ C

and separately:

Copy:

A' ─────→ C'

Every relationship must remain inside the copied structure.

So:

A.random = C

becomes:

A'.random = C' 4. Why Is This Hard?

For a normal linked list:

1 → 2 → 3

we can simply do:

newNode.next = oldNode.next;

But with random pointers:

1.random → 3

when we're creating the copy of 1, we need to know:

Which copied node corresponds to original node 3?

We can't simply do:

copy.random = original.random;

because that points to the original node.

We need:

Original Node → Corresponding Copy Node

This leads directly to the most important idea of this pattern.

5. The Mapping

We create:

Original Node → Copy Node

For example:

A → A'
B → B'
C → C'

In Java:

HashMap<Node, Node> map;

Conceptually:

map

A → A'
B → B'
C → C'

Now if:

A.random → C

we can do:

copyA.random = map.get(A.random);

which gives:

copyA.random → C'

Beautiful.

6. HashMap Solution

This is the easiest solution to understand.

We perform two passes.

Pass 1 — Create Copies

Suppose:

Original:

1 → 2 → 3

Create:

map.put(original, copy);

After traversal:

Original Copy

1 → 1'
2 → 2'
3 → 3'

At this point, we've created all objects.

But we haven't connected their pointers yet.

7. Pass 2 — Connect Pointers

For every original node:

copy.next = map.get(original.next);
copy.random = map.get(original.random);

Suppose:

Original:

1.next = 2
1.random = 3

Then:

Copy:

1'.next = map.get(2)
= 2'

1'.random = map.get(3)
= 3'

Therefore:

1' → 2'

1'
|
random
↓
3' 8. HashMap Template
Map<Node, Node> map = new HashMap<>();

Node curr = head;

// Pass 1: create nodes
while (curr != null) {
map.put(curr, new Node(curr.val));
curr = curr.next;
}

// Pass 2: connect nodes
curr = head;

while (curr != null) {

    Node copy = map.get(curr);


    copy.next = map.get(curr.next);
    copy.random = map.get(curr.random);


    curr = curr.next;

}

return map.get(head);

Notice something elegant:

map.get(null)

returns:

null

So we don't even need special handling for:

next == null
random == null 9. Complexity

Suppose there are N nodes.

Time

Pass 1:

O(N)

Pass 2:

O(N)

Total:

O(N)
Extra Space

HashMap stores:

N mappings

Therefore:

O(N) 10. Can We Do It in O(1) Extra Space?

Yes.

This is the famous O(1) auxiliary-space trick.

Instead of using:

HashMap

we temporarily modify the original list.

This is called Node Weaving.

11. Node Weaving

Original:

1 → 2 → 3

Create copies and insert them immediately after their originals:

1 → 1' → 2 → 2' → 3 → 3'

This gives us an amazing property:

The copy of any node is immediately next to the original node.

Therefore:

copy = original.next

No HashMap needed.

12. Why Is This Useful?

Suppose:

1.random → 3

After weaving:

1 → 1' → 2 → 2' → 3 → 3'

The copy of 3 is:

3'

which is:

original.random.next

Therefore:

copy.random = original.random.next;

That's the key trick.

13. Three Passes

The O(1) solution has three stages.

Pass 1
Create copies and weave them

Pass 2
Set random pointers

Pass 3
Separate original and copied lists

Let's understand each.

Pass 1 — Weave

Original:

1 → 2 → 3

After:

1 → 1' → 2 → 2' → 3 → 3'

Code:

Node copy = new Node(curr.val);

copy.next = curr.next;
curr.next = copy;

curr = copy.next;

Notice the familiar rule:

Save the connection before changing it.

This is directly connected to our Reversal foundation.

Pass 2 — Set Random

Suppose:

1.random → 3

After weaving:

1 → 1' → 2 → 2' → 3 → 3'

The copy of 1 is:

1'

The copy of the random target 3 is:

3'

And:

3' = 3.next

Therefore:

curr.next.random = curr.random.next;

provided:

curr.random != null

So:

if (curr.random != null) {
curr.next.random = curr.random.next;
}
Pass 3 — Separate

Currently:

1 → 1' → 2 → 2' → 3 → 3'

We need:

Original:

1 → 2 → 3

and:

Copy:

1' → 2' → 3'

We reconnect the original nodes:

curr.next = curr.next.next;

and connect copies:

copy.next = copy.next.next; 14. Complete O(1) Solution
class Solution {
public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }


        // Pass 1: weave copied nodes
        Node curr = head;


        while (curr != null) {
            Node copy = new Node(curr.val);


            copy.next = curr.next;
            curr.next = copy;


            curr = copy.next;
        }


        // Pass 2: assign random pointers
        curr = head;


        while (curr != null) {


            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }


            curr = curr.next.next;
        }


        // Pass 3: separate the two lists
        curr = head;
        Node copyHead = head.next;


        while (curr != null) {


            Node copy = curr.next;


            curr.next = copy.next;


            if (copy.next != null) {
                copy.next = copy.next.next;
            }


            curr = curr.next;
        }


        return copyHead;
    }

} 15. HashMap vs O(1) Weaving
HashMap Weaving
Time O(N) O(N)
Extra space O(N) O(1)
Difficulty Easy Hard
Modifies original temporarily No Yes
Interview value ⭐⭐⭐⭐ ⭐⭐⭐⭐⭐ 16. What Should You Learn First?

Definitely:

HashMap solution
↓
Understand mapping
↓
Deep copy
↓
Node weaving
↓
O(1) solution

Don't jump directly to the weaving trick.

The HashMap solution explains what relationship we actually need to preserve.

The O(1) solution simply finds another way to obtain the same mapping:

Original Node → Copy Node

HashMap:

map.get(original)

Weaving:

original.next

That's the beautiful part.

17. The Real Pattern

Don't memorize:

curr.random.next

Understand the transformation:

Original:

A → B → C

becomes:

A → A' → B → B' → C → C'

Therefore:

A' = A.next
B' = B.next
C' = C.next

So if:

A.random → C

then:

A'.random → C'

and:

C' = C.next

Therefore:

A.next.random = A.random.next;

That's derived, not memorized.

Pattern 7 Mental Model
RANDOM POINTER
│
↓
Need a relationship map
│
┌─────────┴─────────┐
↓ ↓
HashMap Weaving
↓ ↓
Original → Copy Original.next = Copy
↓ ↓
O(N) space O(1) space

The core interview question is:

How can I create a completely independent copy while preserving every relationship between nodes?

Once you understand that question, LeetCode 138 stops being a strange linked-list problem and becomes a graph-copy problem implemented using linked-list structure.

WEAVING :

What is Weaving?

Weaving means inserting each copied node immediately after its original node.

Suppose the original list is:

A → B → C → null

Normally, we'd create a separate copy:

Original:
A → B → C

Copy:
A' → B' → C'

With weaving, we temporarily combine them:

A → A' → B → B' → C → C'

That's it.

We have woven/interleaved the original nodes and their copies.

Why Do We Do This?

The problem is the random pointer.

Suppose:

A.random → C

We need the copy to have:

A'.random → C'

But how do we find C'?

With a HashMap:

C → C'

Easy.

But we want O(1) extra space, so we need another way.

We make:

C → C'

physically adjacent.

Because after weaving:

A → A' → B → B' → C → C'

we know:

C' = C.next

That's the entire reason for weaving.

Let's Build It Slowly

Start with:

A → B → C

Create a copy of A:

A'

Normally we'd have:

A → B → C

A'

Instead, insert A' between A and B:

A → A' → B → C

Now create B'.

Insert it between B and C:

A → A' → B → B' → C

Then create C':

A → A' → B → B' → C → C'

That's weaving.

How Do We Insert the Copy?

Suppose we currently have:

A → B

and we created:

A'

We want:

A → A' → B

Remember our pointer-manipulation foundation?

We need to save the old connection first.

Node copy = new Node(curr.val);

copy.next = curr.next;
curr.next = copy;

Let's execute it.

Initially:

curr
↓
A → B
First:
copy.next = curr.next;

Now:

A → B

A' → B

We've made A' point to B.

But A still points to B.

Then:
curr.next = copy;

Now:

A → A' → B

We've inserted the copy.

Do It Again

Move to B.

A → A' → B → C
↑
curr

Create B'.

Insert it:

A → A' → B → B' → C

Then C:

A → A' → B → B' → C → C'

Done.

Now the Magic Becomes Obvious

Suppose the original random pointers are:

A.random → C
B.random → A
C.random → B

After weaving:

A → A' → B → B' → C → C'

Look at A.

A.random
↓
C

Where is the copy of C?

Immediately after C:

C → C'

Therefore:

A.next.random = A.random.next;

Why?

Because:

A.next = A'
A.random = C
A.random.next = C'

So:

A'.random = C'

That's the trick.

The Whole Idea in One Picture

Before weaving:

Original:

A → B → C

Random:

A ───────→ C

After weaving:

A → A' → B → B' → C → C'

Now:

A.random
↓
C
↓ .next
C'

So:

A'.random → C'
Why Is This Called "Weaving"?

Imagine two threads:

Original thread:

A —— B —— C

Copy thread:

A' —— B' —— C'

Instead of keeping them separate, we interleave them:

A —— A' —— B —— B' —— C —— C'

Like weaving two threads together.

That's where the name comes from.

Then We Unweave Them

After setting all the random pointers, we have:

A → A' → B → B' → C → C'

But this isn't our final answer.

We need to separate them again:

Original:

A → B → C

and:

Copy:

A' → B' → C'

This is called unweaving or separating the lists.

The Three Phases

So don't think of weaving as some complicated algorithm.

Think:

Phase 1
Insert copies

A → B → C

        ↓

A → A' → B → B' → C → C'

Phase 2
Use adjacency to set random pointers

A'.random → C'
B'.random → A'
C'.random → B'

Phase 3
Separate the two lists

Original:
A → B → C

Copy:
A' → B' → C'
The Key Insight You Should Remember

The whole O(1) trick exists because we need this mapping:

Original Node → Copy Node

Instead of storing it in a HashMap:

HashMap:

A → A'
B → B'
C → C'

we physically create the mapping:

A → A'
B → B'
C → C'

by putting every copy immediately after its original.

So:

copy of X = X.next

That's weaving.

And this is another perfect example of the pointer principle we learned earlier:

Save the connection → change the connection → preserve access to the rest of the list.
