class Solution {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int currSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currSum = currSum + nums[i];
            ans = Math.max(ans, Math.max(currSum, nums[i]));
            currSum = Math.max(currSum, nums[i]);
        }
        return ans;
    }
}