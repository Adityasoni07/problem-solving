class Solution {
    public int minimumLength(String s) {
        int n = s.length();
        int freq[] = new int[26];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int curr = s.charAt(i) - 'a';
            freq[curr]++;
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0 && freq[i] % 2 == 0) {
                ans += 2;
            } else if (freq[i] % 2 == 1) {
                ans++;
            }
        }
        return ans;
    }
}