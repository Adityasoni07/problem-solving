class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int map[] = new int[10001];
        int left = 0;
        int score = 0;
        int ans = 0;
        for (int right = 0; right < nums.length; right++) {
            map[nums[right]]++;
            score += nums[right];
            while (map[nums[right]] > 1) {
                map[nums[left]]--;
                score -= nums[left];
                left++;
            }
            ans = Math.max(ans, score);
        }
        return ans;
    }
}