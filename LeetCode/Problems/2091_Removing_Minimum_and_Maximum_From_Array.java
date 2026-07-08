class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        int minIdx = 0;
        int maxIdx = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[minIdx]) {
                minIdx = i;
            }
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }

        int frontDeletions = Math.max(minIdx, maxIdx) + 1;
        int backDeletions = n - Math.min(minIdx, maxIdx);
        int bothSidesDeletions = Math.min(minIdx, maxIdx) + 1 + n - Math.max(minIdx, maxIdx);

        return Math.min(frontDeletions, Math.min(backDeletions, bothSidesDeletions));
    }
}