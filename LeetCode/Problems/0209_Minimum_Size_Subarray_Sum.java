class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                ans = Math.min(ans, right - left + 1);
                if (ans == 1) {
                    return 1;
                }
                sum -= nums[left];
                left++;
            }
            right++;
        }
        if (ans == Integer.MAX_VALUE) {
            return 0;
        }
        return ans;
    }
}