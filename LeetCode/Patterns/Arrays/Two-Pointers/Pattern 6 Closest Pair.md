# Pattern 6: Closest Pair

## Idea

Find the **best pair**, not an exact pair.

Every pair is a candidate.

Keep improving the answer.

---

## Mental Model

Ask every iteration:

> **"Is this pair better than my current best?"**

Update the answer first.

Then move pointers exactly like **Opposite Ends**.

---

## Universal Pattern

```java
Arrays.sort(nums);

int left=0;
int right=n-1;

int best=Integer.MAX_VALUE;

while(left<right){

    int sum=nums[left]+nums[right];

    best=Math.min(best,Math.abs(sum-target));

    if(sum<target)
        left++;
    else
        right--;
}
```

---

## Pointer Movement

| Condition       | Move                            |
| --------------- | ------------------------------- |
| `sum < target`  | `left++`                        |
| `sum > target`  | `right--`                       |
| `sum == target` | Perfect answer (usually return) |

---

## Recognition

Think **Closest Pair** when you see:

- Closest
- Nearest
- Minimum Difference
- Minimum Error
- Best Approximation
- Closest Sum

---

## Common Uses

- Closest sum to target
- Minimum absolute difference
- Closest pair between two sorted arrays
- Best approximation problems

---

## Important Problems

### LeetCode

- 16. 3Sum Closest
- 1200. Minimum Absolute Difference

### CP Problems

- Closest Pair Between Two Sorted Arrays
- Closest Pair to Target

---

## Key Difference

| Pattern       | Goal                     |
| ------------- | ------------------------ |
| Opposite Ends | Find an exact pair       |
| Pair Counting | Count valid pairs        |
| Closest Pair  | Optimize the best answer |

---

## Complexity

- Sort: `O(n log n)`
- Two Pointers: `O(n)`
- Overall: `O(n log n)`
