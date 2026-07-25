# Pattern: Prefix State Encoding (Bitmask)

## Big Idea

Prefix State Encoding is **not a new algorithm**.

It is a specialization of **Prefix Sum + HashMap**, where instead of storing a numeric prefix sum, we store a **bitmask representing the current state**.

The pattern is useful when we only care about **binary states** (On/Off, Odd/Even, Present/Absent).

---

# When Should I Think About This Pattern?

Look for problems containing phrases like:

- Even / Odd frequency
- Parity
- Rearrange into palindrome
- Every character appears even number of times
- At most one odd frequency
- Multiple binary conditions
- Toggle state
- Longest substring satisfying parity conditions
- Count substrings satisfying parity conditions

If every tracked property has only **2 possible states**, think:

> **Prefix State Encoding (Bitmask)**

---

# Core Idea

Suppose we track vowels.

```
a
e
i
o
u
```

Each vowel has only two states.

```
Even
Odd
```

Represent them with one bit.

```
0 = Even
1 = Odd
```

Assign bits:

```
Bit 0 -> a
Bit 1 -> e
Bit 2 -> i
Bit 3 -> o
Bit 4 -> u
```

Example

```
00000
```

means

```
a = even
e = even
i = even
o = even
u = even
```

Example

```
10110
```

means

```
a = even
e = odd
i = odd
o = even
u = odd
```

The entire parity information is stored inside one integer.

---

# Why Use XOR?

Whenever a tracked character appears, its parity changes.

Example

```
Even -> Odd
Odd -> Even
```

XOR does exactly this.

```
0 ^ 1 = 1

1 ^ 1 = 0
```

Updating the state:

```java
state = (1<<vowel)

example: if voewl = 'a' so 1 << 0 -> 00001

mask ^= (1 << bit); or mask ^= (state);
```

This means:

> Toggle the parity of this character.

---

# Mental Model

Imagine several light switches.

```
a e i o u

OFF OFF OFF OFF OFF
```

Reading 'a'

```
ON OFF OFF OFF OFF
```

Reading another 'a'

```
OFF OFF OFF OFF OFF
```

Each occurrence simply flips one switch.

The current arrangement of switches is the **prefix state**.

---

# Why Does the Same State Matter?

Suppose

```
Index     State

-1        00000
7         10110
18        10110
```

The state is identical.

This means every tracked bit changed an even number of times.

Therefore,

every tracked character appears an even number of times inside the substring.

This is exactly the same principle as Prefix Sum and Prefix Balance.

---

# General Algorithm

Initialize

```java
Map<Integer, Integer> map = new HashMap<>();

map.put(0, -1);

int mask = 0;
```

For every character

```
Update mask

↓

Have I seen this mask before?

↓

Yes

↓

Update answer

↓

Store first occurrence
```

Skeleton

```java
Map<Integer,Integer> map = new HashMap<>();

map.put(0,-1);

int mask = 0;

for(...) {

    // Toggle corresponding bit

    mask ^= (1 << bit);

    if(map.containsKey(mask)) {

        ans = Math.max(ans, i - map.get(mask));

    }

    map.putIfAbsent(mask, i);
}
```

---

# Why Store First Index?

Example

```
State X

Index

2
7
15
```

Current index

```
15
```

Possible lengths

```
15 - 2 = 13

15 - 7 = 8
```

Earliest occurrence always gives the longest substring.

Therefore

```java
map.putIfAbsent(mask, i);
```

Never overwrite.

---

# Important Observation

We never care about actual frequencies.

Example

```
a = 57
```

and

```
a = 3
```

Both are

```
Odd
```

The exact count is irrelevant.

Only parity matters.

---

# Pattern Variations

## Variation 1

### Every tracked element must be even

Search

```
Same mask
```

Because

```
Current XOR Previous = 00000...
```

Example

LeetCode 1371

---

## Variation 2

### At most one odd frequency

Search

```
Same mask
```

AND

```
mask ^ (1<<0)

mask ^ (1<<1)

...

mask ^ (1<<k)
```

One flipped bit means

Exactly one odd frequency.

Example

LeetCode 1542

---

## Variation 3

### Counting instead of longest

Instead of storing

```
Mask -> First Index
```

Store

```
Mask -> Frequency
```

Then

```
answer += frequency
```

Example

LeetCode 1915

---

# Recognition Checklist

Ask yourself:

1. Are there multiple independent conditions?

2. Does every condition have only two states?

3. Can one bit represent each condition?

4. Is the problem asking about substrings?

5. Can I represent the current state as a bitmask?

If YES,

Think

```
Prefix State Encoding + HashMap
```

---

# Complexity

Suppose

```
k = number of tracked characters
```

Time

```
O(n × k)
```

Usually

```
k <= 10
```

which is effectively

```
O(n)
```

Space

```
O(2^k)
```

Examples

```
5 vowels

2^5 = 32 states
```

```
10 digits

2^10 = 1024 states
```

Very small.

---

# Common Mistakes

### Mistake 1

Using counts instead of parity.

Wrong

```
count++
```

Think

```
Odd / Even
```

---

### Mistake 2

Using OR instead of XOR.

Wrong

```java
mask |= (1 << bit);
```

Correct

```java
mask ^= (1 << bit);
```

Because parity flips.

---

### Mistake 3

Overwriting first occurrence.

Wrong

```java
map.put(mask, i);
```

Correct

```java
map.putIfAbsent(mask, i);
```

---

### Mistake 4

Forgetting to initialize

```java
map.put(0, -1);
```

Without this,

substrings starting at index 0 are missed.

---

# Mental Flow

```
Scan String

↓

Update Current State

↓

Convert State into Bitmask

↓

Have I Seen This State Before?

↓

YES

↓

Substring Satisfies Required Condition

↓

Update Answer

↓

Store State if First Time
```

---

# Genuine Interview Problems

## Foundation

1371. Find the Longest Substring Containing Vowels in Even Counts

Concept

- Same mask
- Longest substring

---

## Advanced

1542. Find Longest Awesome Substring

Concept

- Same mask
- One-bit difference
- Palindrome parity

---

## Counting Version

1915. Number of Wonderful Substrings

Concept

- Same mask
- One-bit difference
- Frequency HashMap

---

## Tree Version (Expert)

2791. Count Paths That Can Form a Palindrome in a Tree

Concept

- Prefix mask on DFS path
- Same parity logic

---

# Relationship with Other Prefix Patterns

```
Prefix Sum + HashMap
│
├── Prefix Frequency
│     Key = Prefix Sum
│
├── Prefix Balance
│     Key = Balance
│
├── Prefix Modulo
│     Key = PrefixSum % K
│
└── Prefix State Encoding
      Key = Bitmask State
```

The algorithm never changes.

Only the definition of the running state changes.

---

# Golden Rule

> Maintain a running **bitmask state** where each bit represents a binary property (odd/even, on/off, present/absent). Store the earliest occurrence (or frequency) of each state in a HashMap. When the current state matches the required previous state (same mask or one-bit-different mask), the substring between them satisfies the required condition.
