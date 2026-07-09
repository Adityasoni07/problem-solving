class Solution {
    public int characterReplacement(String s, int k) {
        int freq[] = new int[26];
        int n = s.length();
        int maxFreq = 0;
        int left = 0;
        int ans = 0;
        for (int right = 0; right < n; right++) {
            int curr = s.charAt(right) - 'A';
            freq[curr]++;
            maxFreq = Math.max(maxFreq, freq[curr]);
            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}