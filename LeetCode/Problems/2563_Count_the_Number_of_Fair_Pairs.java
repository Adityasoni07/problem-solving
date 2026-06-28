import java.util.Arrays;

class Solution {

    public long countAtMost(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        long count = 0;

        while (left < right) {
            if (nums[left] + nums[right] <= target) {
                count += (right - left);
                left++;
            } else {
                right--;
            }
        }

        return count;
    }

    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);

        return countAtMost(nums, upper) - countAtMost(nums, lower - 1);
    }
}