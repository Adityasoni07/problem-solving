class Solution {
    public int sumOfBeauties(int[] nums) {
        int n = nums.length;
        int max[] = new int[n];
        max[0] = nums[0];
        int min[] = new int[n];
        min[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            max[i] = Math.max(max[i - 1], nums[i]);
            min[n - i - 1] = Math.min(min[n - i], nums[n - i - 1]);
        }
        int sum = 0;
        for (int i = 1; i < n - 1; i++) {
            if (max[i - 1] < nums[i] && nums[i] < min[i + 1]) {
                sum += 2;
            } else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
                sum++;
            }
        }
        return sum;
    }
}