class Solution {
    public int maxProduct(int[] nums) {
        int max1 = 0;
        int max2 = 0;
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (max1 <= curr) {
                max2 = max1;
                max1 = curr;
            } else if (max2 <= curr) {
                max2 = curr;
            }
        }
        return (max1 - 1) * (max2 - 1);
    }
}