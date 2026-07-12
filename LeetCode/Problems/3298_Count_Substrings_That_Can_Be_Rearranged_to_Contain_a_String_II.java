class Solution {
    public long validSubstringCount(String word1, String word2) {
        if (word1.length() < word2.length()) {
            return 0;
        }
        int freq2[] = new int[26];
        int unique = 0;
        for (char ch : word2.toCharArray()) {
            if (freq2[ch - 'a'] == 0) {
                unique++;
            }
            freq2[ch - 'a']++;
        }
        long ans = 0;
        int n = word1.length();
        int valid = 0;
        int left = 0;
        int freq1[] = new int[26];
        for (int right = 0; right < n; right++) {
            int idx = word1.charAt(right) - 'a';
            if (freq2[idx] > 0) {
                freq1[idx]++;
                if (freq1[idx] == freq2[idx]) {
                    valid++;
                }
            }
            while (valid == unique) {
                ans = ans + (n - right);
                int c = word1.charAt(left) - 'a';
                if (freq2[c] > 0) {
                    if (freq1[c] == freq2[c]) {
                        valid--;
                    }
                    freq1[c]--;
                }
                left++;
            }
        }
        return ans;
    }
}