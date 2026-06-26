class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0;
        int freq = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[k] == nums[i]) {
                if (freq < 2) {
                    nums[++k] = nums[i];
                    freq++;
                }
            } else {
                nums[++k] = nums[i];
                freq = 1;
            }
        }
        return k + 1;
    }
}