import java.util.*;

class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        long windowSum = 0;
        int left = 0;
        int ans = 0;
        for (int right = 0; right < nums.length; right++) {
            int curr = nums[right];
            windowSum += curr;
            while ((long) curr * (right - left + 1) - windowSum > k) {
                windowSum -= nums[left];
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}