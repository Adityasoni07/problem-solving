class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        int left = 0;
        int right = n - 1;
        int i = n - 1;
        while (left <= right) {
            int s1 = nums[left] * nums[left];
            int s2 = nums[right] * nums[right];
            if (s1 > s2) {
                ans[i] = s1;
                left++;
            } else {
                ans[i] = s2;
                right--;
            }
            i--;
        }
        return ans;
    }
}