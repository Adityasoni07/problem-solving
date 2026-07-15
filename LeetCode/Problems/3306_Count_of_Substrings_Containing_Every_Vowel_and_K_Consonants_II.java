class Solution {
    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public long atLeast(String word, int k) {
        int freq[] = new int[26];
        int n = word.length();
        long count = 0;
        int vowels = 0;
        int cons = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            char curr = word.charAt(right);
            freq[curr - 'a']++;
            if (isVowel(curr)) {
                if (freq[curr - 'a'] == 1) {
                    vowels++;
                }
            } else {
                cons++;
            }
            while (vowels == 5 && cons >= k) {
                count += (n - right);
                char leftCurr = word.charAt(left);
                freq[leftCurr - 'a']--;
                if (isVowel(leftCurr)) {
                    if (freq[leftCurr - 'a'] == 0) {
                        vowels--;
                    }
                } else {
                    cons--;
                }
                left++;
            }
        }
        return count;
    }

    public long countOfSubstrings(String word, int k) {
        return atLeast(word, k) - atLeast(word, k + 1);
    }
}