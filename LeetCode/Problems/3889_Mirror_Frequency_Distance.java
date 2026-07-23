class Solution {
    public int mirrorFrequency(String s) {
        int freq[] = new int[128];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char curr = s.charAt(i);
            freq[curr]++;
        }
        int ans = 0;
        for (int i = 'a'; i <= 'z'; i++) {
            if (freq[i] > 0) {
                char mirror = (char) ('z' - (i - 'a'));
                ans += Math.abs(freq[i] - freq[mirror]);
                freq[i] = 0;
                freq[mirror] = 0;
            }
        }
        for (int i = '0'; i <= '9'; i++) {
            if (freq[i] > 0) {
                char mirror = (char) ('9' - (i - '0'));
                ans += Math.abs(freq[i] - freq[mirror]);
                freq[i] = 0;
                freq[mirror] = 0;
            }
        }
        return ans;
    }
}