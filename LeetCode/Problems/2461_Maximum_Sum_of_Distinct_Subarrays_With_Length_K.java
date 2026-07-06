class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int arr[] = new int[100001];
        long maxSum = 0;
        long sum = 0;
        int duplicates = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
            arr[nums[i]]++;
            if (arr[nums[i]] == 2) {
                duplicates++;
            }
        }
        if (duplicates == 0) {
            maxSum = Math.max(maxSum, sum);
        }
        for (int i = k; i < nums.length; i++) {
            sum += nums[i];
            arr[nums[i]]++;
            if (arr[nums[i]] == 2) {
                duplicates++;
            }

            if (arr[nums[i - k]] == 2) {
                duplicates--;
            }
            sum -= nums[i - k];
            arr[nums[i - k]]--;
            if (duplicates == 0) {
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}