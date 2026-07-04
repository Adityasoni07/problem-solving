//Q1. Unique Middle Element
//(Easy)

class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        int n = nums.length;
        int mid = nums[n / 2];
        int left = 0;
        int right = n - 1;
        while (left < right) {
            if (nums[left] == mid || nums[right] == mid) {
                return false;
            }
            right--;
            left++;
        }
        return true;
    }
}