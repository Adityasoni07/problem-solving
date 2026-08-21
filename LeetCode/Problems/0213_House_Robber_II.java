import java.util.*;

class Solution {
    int[] dp;
    int n;

    public int robbing(int[] nums, int i) {
        if (i >= n) {
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
        n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        dp = new int[n];
        Arrays.fill(dp, -1);
        int firstHalf = robbing(nums, 1);
        dp = new int[n];
        Arrays.fill(dp, -1);
        n--;
        int secondHalf = robbing(nums, 0);
        return Math.max(firstHalf, secondHalf);
    }
}