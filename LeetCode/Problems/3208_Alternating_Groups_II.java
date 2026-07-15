class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int ans = 0;
        int left = 0;
        for (int right = 1; right < n + n - 1; right++) {
            if (colors[(right - 1) % n] == colors[right % n]) {
                left = right;
            }
            if (right - left + 1 == k) {
                if (left < n) {
                    ans++;
                }
                left++;
            }
        }
        return ans;
    }
}