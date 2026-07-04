class Solution {
    public int countKDifference(int[] nums, int k) {
        int count[] = new int[101];
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - k >= 0) {
                ans += count[nums[i] - k];
            }
            if (nums[i] + k <= 100) {
                ans += count[nums[i] + k];
            }
            count[nums[i]]++;
        }
        return ans;
    }
}