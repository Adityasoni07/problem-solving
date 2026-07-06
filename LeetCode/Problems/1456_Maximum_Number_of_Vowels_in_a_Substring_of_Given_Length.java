class Solution {
    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public int maxVowels(String s, int k) {
        int n = s.length();
        int max = 0;
        int vowels = 0;
        for (int i = 0; i < n; i++) {
            char right = s.charAt(i);
            if (isVowel(right)) {
                vowels++;
            }
            if (i >= k) {
                char left = s.charAt(i - k);
                if (isVowel(left)) {
                    vowels--;
                }
            }
            max = Math.max(max, vowels);
            if (max == k) {
                return max;
            }
        }
        return max;
    }
}