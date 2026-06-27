class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) {
                int temp = nums[k];
                nums[k++] = nums[i];
                nums[i] = temp;
            }
        }
        int j = n / 2;
        if (j % 2 == 1) {
            j++;
        }
        for (int i = 1; i < n / 2; i += 2) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            j += 2;
        }
        return nums;
    }
}