class Solution {
    public boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public long countVowels(String word) {
        int n = word.length();
        long ans = 0;
        for (int right = 0; right < n; right++) {
            char curr = word.charAt(right);
            if (isVowel(curr)) {
                ans += (long) (right + 1) * (n - right);
            }
        }
        return ans;
    }
}