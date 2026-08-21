class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int len = 0;
        int value = 0;
        int i = 0;
        while (i < n) {
            if (nums[i] >= value) {
                int j = i;
                while (i < n && nums[i] == nums[j]) {
                    i++;
                }
                if (nums[j] > value || i - j > len) {
                    value = nums[j];
                    len = i - j;
                }
            } else {
                i++;
            }
        }
        return len;
    }
}