class Solution {
    public int atMost(int nums[], int k) {
        if (k < 0)
            return 0;
        int left = 0;
        int ones = 0;
        int ans = 0;

        for (int right = 0; right < nums.length; right++) {

            if (nums[right] == 1) {
                ones++;
            }

            while (ones > k) {
                if (nums[left] == 1) {
                    ones--;
                }
                left++;
            }

            ans += right - left + 1;
        }

        return ans;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }
}