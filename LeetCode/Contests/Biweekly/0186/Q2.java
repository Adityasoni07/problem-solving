// Q2. Maximum Valid Pair Sum
//(Medium)

class Solution {
    public int maxValidPairSum(int[] nums, int k) {
        int n = nums.length;

        int[] arr = new int[n];
        arr[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            arr[i] = Math.max(arr[i + 1], nums[i]);
        }

        int ans = Integer.MIN_VALUE;

        for (int i = 0; i + k < n; i++) {
            ans = Math.max(ans, nums[i] + arr[i + k]);
        }

        return ans;
    }
}