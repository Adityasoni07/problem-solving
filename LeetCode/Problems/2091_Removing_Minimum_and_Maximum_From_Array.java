class Solution {
    public int minimumDeletions(int[] nums) {
        int minIdx = 0;
        int maxIdx = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] < nums[minIdx]) {
                minIdx = i;
            }
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }
        int front;
        int back;
        if (minIdx < maxIdx) {
            front = minIdx + 1;
            back = n - maxIdx;
        } else {
            front = maxIdx + 1;
            back = n - minIdx;
        }
        return Math.min(front + back, Math.min(Math.max(minIdx + 1, maxIdx + 1),
                Math.max(n - maxIdx, n - minIdx)));
    }
}