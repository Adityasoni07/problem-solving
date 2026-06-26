class Solution {
    public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int i = 0;
        while (i <= end) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[start];
                nums[start] = temp;
                start++;
                i++;
            } else if (nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[end];
                nums[end] = temp;
                end--;
            } else {
                i++;
            }
        }
    }
}