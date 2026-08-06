class Solution {
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int arr[] = new int[len];
        for (int i = 0; i < len; i++) {
            if (arr[nums[i]] == 0) {
                arr[nums[i]] = nums[i];
            } else {
                return nums[i];
            }
        }
        return 0;
    }
}