import java.util.Arrays;

class Solution {
    public int majorityElement(int[] nums) {
        int count = 1, t = nums.length / 2, ele = nums[0];
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
                if (count > t) {
                    ele = nums[i];
                    break;
                }
            } else {
                count = 1;
            }
        }
        return ele;
    }
}