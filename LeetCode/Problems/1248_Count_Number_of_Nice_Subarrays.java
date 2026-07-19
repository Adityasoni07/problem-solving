class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int map[] = new int[100001];
        int odds = 0;
        map[0] = 1;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                odds++;
            }
            int prev = odds - k;
            if (prev >= 0) {
                ans += map[prev];
            }
            map[odds]++;
        }
        return ans;
    }
}