class Solution {
    public int longestSubarray(int[] nums) {
        int ans = 2;
        int count = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i - 2] + nums[i - 1] == nums[i]) {
                count++;
            } else {
                ans = Math.max(count, ans);
                count = 2;
            }
        }
        return Math.max(count, ans);
    }
}