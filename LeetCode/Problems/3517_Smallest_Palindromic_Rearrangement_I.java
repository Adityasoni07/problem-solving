class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        char[] ans = new char[n];
        int left = 0;
        int right = n - 1;

        for (int i = 0; i < 26; i++) {
            while (freq[i] >= 2) {
                char c = (char) ('a' + i);
                ans[left++] = c;
                ans[right--] = c;
                freq[i] -= 2;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] == 1) {
                ans[left] = (char) ('a' + i);
                break;
            }
        }

        return new String(ans);
    }
}