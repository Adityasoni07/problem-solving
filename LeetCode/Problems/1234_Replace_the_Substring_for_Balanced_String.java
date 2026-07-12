class Solution {
    public int balancedString(String s) {
        int n = s.length();
        int target = n / 4;

        int[] freq = new int[128];

        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        if (freq['Q'] == target && freq['W'] == target && freq['E'] == target && freq['R'] == target) {
            return 0;
        }

        int left = 0;
        int ans = n;

        for (int right = 0; right < n; right++) {

            freq[s.charAt(right)]--;

            while (left <= right && freq['Q'] <= target && freq['W'] <= target && freq['E'] <= target
                    && freq['R'] <= target) {
                ans = Math.min(ans, right - left + 1);
                freq[s.charAt(left)]++;
                left++;
            }
        }

        return ans;
    }
}