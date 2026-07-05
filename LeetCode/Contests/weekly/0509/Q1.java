// Q1. Sum of Integers with Maximum Digit Range
// Easy

class Solution {
    public int maxDigitRange(int[] nums) {
        int arr[] = new int[100001];
        int n = nums.length;
        int maxDiff = -1;
        for (int i = 0; i < n; i++) {
            int curr = nums[i];
            int min = curr % 10;
            int max = curr % 10;
            while (curr != 0) {
                int temp = curr % 10;
                max = Math.max(temp, max);
                min = Math.min(temp, min);
                curr = curr / 10;
            }
            arr[nums[i]] = max - min;
            maxDiff = Math.max(maxDiff, max - min);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (arr[nums[i]] == maxDiff) {
                ans += nums[i];
            }
        }
        return ans;
    }
}