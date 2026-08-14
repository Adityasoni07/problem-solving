class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int[] freq = new int[26];
        int left = 0;
        int max = 0;
        for (int right = 0; right < n; right++) {
            char curr = s.charAt(right);
            freq[curr - 'a']++;
            while (freq[curr - 'a'] > 2) {
                char leftCurr = s.charAt(left);
                freq[leftCurr - 'a']--;
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}