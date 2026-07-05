import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> partitionLabels(String s) {
        int freq[] = new int[26];
        int n = s.length();
        int unique = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            freq[c - 'a']++;
            if (freq[c - 'a'] == 1) {
                unique++;
            }
        }
        int size = unique;
        int count = 1;
        int valid[] = new int[26];
        int appears = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (valid[c - 'a'] == 0) {
                valid[c - 'a'] = 1;
                appears++;
            }
            freq[c - 'a']--;
            if (freq[c - 'a'] == 0) {
                size--;
            }
            if (unique - appears == size) {
                ans.add(count);
                count = 1;
            } else {
                count++;
            }
        }
        return ans;
    }
}