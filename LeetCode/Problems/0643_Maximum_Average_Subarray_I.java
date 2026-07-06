class Solution {
    public double findMaxAverage(int[] nums, int k) {
       double sum = 0;
       for (int n = 0; n < k; n++) {
        sum += nums[n];
       }
       double res = sum;
       for (int i = k; i < nums.length; i++){
        sum += nums[i] - nums[i-k];
        res = Math.max(res, sum);
       }
       return res/k;
        
    }
}