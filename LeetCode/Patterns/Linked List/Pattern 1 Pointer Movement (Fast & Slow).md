# Pattern 1 — Pointer Movement (Fast & Slow)

## One-Line Understanding

**Fast & Slow is a pointer-movement technique that uses different traversal speeds to learn information about a linked structure without extra memory.**

The important idea is not the code.

It is the **relative position of two pointers**.

---

# Core Mindset

Different patterns maintain different kinds of state:

Pointer Movement
→ Relative Position State

You don't care only about where one pointer is.

You care about:

> **Where are the two pointers relative to each other?**

---

# What Problems Does It Solve?

Whenever you see:

- Find middle
- Detect cycle
- Detect loop
- Find cycle start
- Split list
- Palindrome
- Happy Number
- Duplicate caused by cycle-like structure

Ask:

> **Can two pointers move at different speeds?**

---

# Why Fast & Slow Exists

Suppose we need to find the middle of:

1 → 2 → 3 → 4 → 5

The middle is:

3

A simple approach:

1. Traverse once to find the length.
2. Traverse again to reach the middle.

This takes two traversals.

The Fast & Slow technique finds the middle in one traversal.

---

# Core Idea

Use two pointers:

slow → moves 1 node at a time

fast → moves 2 nodes at a time
java
slow = slow.next;
fast = fast.next.next;

Think of two runners:

Slow → 1 step

Fast → 2 steps

When Fast reaches the end, Slow is approximately halfway through the list.

That gives us the middle.

---

# The Main Invariant

The most important thing to understand is the **relative speed**.

Fast moves twice as fast as Slow.

Therefore, approximately:

# distance(fast)

2 × distance(slow)

When Fast has travelled the entire list,

Slow has travelled approximately half.

Therefore:

Slow → Middle
Fast → End

This is the fundamental idea behind finding the middle.

---

# Deriving the Code

We don't memorize the code.

We derive it from the idea.

### Slow

Move one node:
java
slow = slow.next;

### Fast

Move two nodes:
java
fast = fast.next.next;

Therefore:
java
slow = slow.next;
fast = fast.next.next;

---

# Universal Initialization

java
ListNode slow = head;
ListNode fast = head;

Both start from the same position.

Then Fast gradually moves ahead.

---

# Universal Movement

java
slow = slow.next;
fast = fast.next.next;

The exact stopping condition depends on the problem.

For many linked-list Fast & Slow problems:
java
while (fast != null && fast.next != null) {
slow = slow.next;
fast = fast.next.next;
}

This condition ensures that accessing:
java
fast.next.next

does not cause a null-pointer error.

---

# Four Components of Fast & Slow

Every Fast & Slow problem can be understood through four things.

## 1. Initialization

java
slow = head;
fast = head;

## 2. Pointer Movement

java
slow = slow.next;
fast = fast.next.next;

## 3. Invariant

The invariant depends on the problem.

### Middle

Fast moves twice as fast as Slow.

### Cycle Detection

The relative distance between Fast and Slow changes according to the cycle length.

### Cycle Entry

The distances from the head and from the meeting point provide the relationship needed to locate the cycle start.

These should be **derived**, not blindly memorized.

## 4. Stop Condition

Commonly:
java
while (fast != null && fast.next != null)

---

# Pattern Recognition

Ask these questions:

1. Can two traversals be reduced to one?
2. Is the problem about the relative position of two pointers?
3. Is the answer somewhere around the middle?
4. Is there a cycle or loop?
5. Can one pointer chase another?

If yes:

Think Fast & Slow.

---

# Main Applications

## 1. Find Middle

Fast reaches the end.

Slow reaches the middle.

**LeetCode 876 — Middle of the Linked List**

---

## 2. Cycle Detection

Two pointers move at different speeds.

If a cycle exists, they eventually meet.

**LeetCode 141 — Linked List Cycle**

---

## 3. Cycle Entry

First detect a meeting point.

Then use the mathematical relationship between:

Head
Meeting Point
Cycle Start

to find the beginning of the cycle.

**LeetCode 142 — Linked List Cycle II**

---

## 4. Mathematical Cycle Detection

Fast & Slow is not limited to linked lists.

Any process where:

current state → next state

can potentially be treated like a linked structure.

Example:

202 — Happy Number

The sequence of numbers eventually either reaches `1` or enters a cycle.

---

## 5. Array as a Linked Structure

In:

287 — Find the Duplicate Number

we can interpret:

index → nums[index]

as a linked structure.

Then Floyd's Cycle Detection can be applied.

This is one of the most important non-linked-list applications of Fast & Slow.

---

# Pattern 1 Problem Roadmap

## Level 1 — Core Foundation

| Order | LeetCode | Problem                   | Core Idea                              |
| ----: | -------: | ------------------------- | -------------------------------------- |
|     1 |  **876** | Middle of the Linked List | Fast reaches end → Slow reaches middle |
|     2 |  **141** | Linked List Cycle         | Detect meeting                         |
|     3 |  **142** | Linked List Cycle II      | Find cycle entry                       |
|     4 |  **202** | Happy Number              | Floyd Cycle Detection                  |
|     5 |  **287** | Find the Duplicate Number | Floyd Cycle Detection on array         |

These five are the core problems of the pattern.

---

# Level 2 — Direct Applications

These use Fast & Slow as an important primary step.

| Order | LeetCode | Problem                                 | Main Fast & Slow Use |
| ----: | -------: | --------------------------------------- | -------------------- |
|     6 | **2095** | Delete the Middle Node of a Linked List | Find middle          |
|     7 |  **234** | Palindrome Linked List                  | Find middle          |

**234** also involves reversal, so Fast & Slow is only one part of the complete solution.

---

# Level 3 — Pattern Combinations

These combine Fast & Slow with other techniques.

| Order | LeetCode | Problem                                   | Combination               |
| ----: | -------: | ----------------------------------------- | ------------------------- |
|     8 |  **143** | Reorder List                              | Middle + Reverse + Merge  |
|     9 |  **148** | Sort List                                 | Middle + Merge Sort       |
|    10 |  **109** | Convert Sorted List to Binary Search Tree | Middle + Divide & Conquer |
|    11 | **2130** | Maximum Twin Sum of a Linked List         | Middle + Reverse          |

These are useful after the core pattern is mastered.

---

# Recommended Learning Order

Pattern 1 — Pointer Movement
│
├── Level 1 — Understand
│ └── 876 → Middle of the Linked List
│
├── Level 2 — Master Floyd
│ ├── 141 → Linked List Cycle
│ └── 142 → Linked List Cycle II
│
├── Level 3 — Generalize Floyd
│ ├── 202 → Happy Number
│ └── 287 → Find the Duplicate Number
│
├── Level 4 — Applications
│ ├── 2095 → Delete Middle Node
│ └── 234 → Palindrome Linked List
│
└── Level 5 — Pattern Combination
├── 143 → Reorder List
├── 148 → Sort List
├── 109 → Sorted List → BST
└── 2130 → Maximum Twin Sum

---

# Must-Master Problems

If you want the highest-value set, master these five first:

1. **876 — Middle of the Linked List**
2. **141 — Linked List Cycle**
3. **142 — Linked List Cycle II**
4. **202 — Happy Number**
5. **287 — Find the Duplicate Number**

These cover the fundamental Fast & Slow ideas before moving into combinations.

---

# Recognition Cheat Sheet

| Problem Clue                      | Think                             |
| --------------------------------- | --------------------------------- |
| Middle of linked list             | Fast & Slow                       |
| Cycle / loop                      | Floyd                             |
| Cycle start                       | Floyd + mathematical relationship |
| Happy Number                      | Fast & Slow cycle detection       |
| Duplicate Number                  | Array → Linked Structure → Floyd  |
| Two traversals can become one     | Fast & Slow                       |
| Relative pointer positions matter | Fast & Slow                       |

---

# Golden Rule

Don't memorize:
java
slow = slow.next;
fast = fast.next.next;

Memorize the **idea**:

> **Use different pointer speeds to create useful relative-position information.**

Then derive the movement and stopping condition from the invariant of the specific problem.

---

# One-Line Memory Trick

**Fast & Slow = Different Speeds → Relative Position → Hidden Information**

For the core applications:

Fast reaches end
↓
Slow reaches middle

Fast + Slow meet
↓
Cycle exists

Meeting point + mathematical relationship
↓
Cycle entry
