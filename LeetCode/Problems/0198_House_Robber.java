import java.util.*;

class Solution {
    int[] dp;

    public int robbing(int[] nums, int i) {
        if (i >= nums.length) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int take = nums[i] + robbing(nums, i + 2);
        int skip = robbing(nums, i + 1);

        dp[i] = Math.max(take, skip);

        return dp[i];
    }

    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return robbing(nums, 0);
    }
}