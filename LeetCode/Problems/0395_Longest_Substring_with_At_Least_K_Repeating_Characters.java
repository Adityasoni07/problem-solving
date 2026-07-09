class Solution {
    public int longestSubstring(String s, int k) {
        int ans = 0;

        for (int targetUnique = 1; targetUnique <= 26; targetUnique++) {

            int[] freq = new int[26];
            int left = 0;
            int right = 0;

            int unique = 0;
            int countAtLeastK = 0;

            while (right < s.length()) {
                int idx = s.charAt(right) - 'a';

                if (freq[idx] == 0)
                    unique++;

                freq[idx]++;

                if (freq[idx] == k)
                    countAtLeastK++;

                right++;

                while (unique > targetUnique) {

                    idx = s.charAt(left) - 'a';

                    if (freq[idx] == k)
                        countAtLeastK--;

                    freq[idx]--;

                    if (freq[idx] == 0)
                        unique--;

                    left++;
                }

                if (unique == targetUnique && unique == countAtLeastK) {
                    ans = Math.max(ans, right - left);
                }
            }
        }

        return ans;
    }
}