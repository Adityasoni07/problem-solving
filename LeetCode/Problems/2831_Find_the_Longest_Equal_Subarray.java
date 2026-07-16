import java.util.List;

class Solution {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        int freq[] = new int[100001];
        int maxFreq = 0;
        int longest = 0;
        int n = nums.size();
        int left = 0;
        for (int right = 0; right < n; right++) {
            int curr = nums.get(right);
            freq[curr]++;
            maxFreq = Math.max(maxFreq, freq[curr]);
            while ((right - left + 1) - maxFreq > k) {
                int leftCurr = nums.get(left);
                freq[leftCurr]--;
                left++;
            }
            longest = Math.max(longest, maxFreq);
        }
        return longest;
    }
}