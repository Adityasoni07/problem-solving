class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();

        String ans = "";
        int left = 0;
        int ones = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            if (s.charAt(right) == '1') {
                ones++;
            }

            while (ones > k) {
                if (s.charAt(left) == '1') {
                    ones--;
                }
                left++;
            }

            while (ones == k && s.charAt(left) == '0') {
                left++;
            }

            if (ones == k) {
                String curr = s.substring(left, right + 1);
                int len = right - left + 1;

                if (len < minLen) {
                    minLen = len;
                    ans = curr;
                } else if (len == minLen && curr.compareTo(ans) < 0) {
                    ans = curr;
                }
            }
        }

        return ans;
    }
}