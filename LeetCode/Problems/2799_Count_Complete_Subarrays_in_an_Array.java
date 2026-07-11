class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        int freq1[] = new int[2001];
        int distinct = 0;
        for (int i = 0; i < n; i++) {
            freq1[nums[i]]++;
            if (freq1[nums[i]] == 1) {
                distinct++;
            }
        }

        int freq2[] = new int[2001];
        int left = 0;
        int ans = 0;
        int currDistinct = 0;
        for (int right = 0; right < n; right++) {
            freq2[nums[right]]++;
            if (freq2[nums[right]] == 1) {
                currDistinct++;
            }
            while (currDistinct == distinct) {
                ans = ans + (n - right);
                freq2[nums[left]]--;
                if (freq2[nums[left]] == 0) {
                    currDistinct--;
                }
                left++;
            }
        }
        return ans;
    }
}