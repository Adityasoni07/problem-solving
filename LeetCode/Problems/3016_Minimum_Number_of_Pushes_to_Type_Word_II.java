import java.util.*;

class Solution {
    public int minimumPushes(String word) {
        int freq[] = new int[26];
        int ans = 0;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char curr = word.charAt(i);
            freq[curr - 'a']++;
        }
        Arrays.sort(freq);
        int j = 0;
        for (int i = 25; i >= 0; i--) {
            if (freq[i] > 0) {
                ans += ((j / 8) + 1) * freq[i];
                j++;
            }
        }
        return ans;
    }
}