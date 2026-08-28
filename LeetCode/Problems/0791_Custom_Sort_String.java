import java.util.*;

class Solution {
    public String customSortString(String order, String s) {
        int freq[] = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char curr = s.charAt(i);
            freq[curr - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        int m = order.length();
        for (int i = 0; i < m; i++) {
            char curr = order.charAt(i);
            while (freq[curr - 'a'] > 0) {
                sb.append(curr);
                freq[curr - 'a']--;
            }
        }
        for (int i = 0; i < 26; i++) {
            while (freq[i] > 0) {
                sb.append((char) (i + 'a'));
                freq[i]--;
            }
        }
        return sb.toString();
    }
}