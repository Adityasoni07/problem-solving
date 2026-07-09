class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[128];
        int n = s.length();
        int left = 0;
        int ans = 0;
        for (int right = 0; right < n; right++) {
            char curr = s.charAt(right);
            map[curr]++;
            while (map[curr] > 1) {
                char leftChar = s.charAt(left);
                map[leftChar]--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}