class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < n; i++) {
            ans[i] = Math.abs(ans[i] - leftSum);
            ans[n - i - 1] = Math.abs(ans[n - i - 1] - rightSum);
            leftSum += nums[i];
            rightSum += nums[n - i - 1];
        }
        return ans;
    }
}