import java.util.HashSet;

class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        HashSet<Integer> used = new HashSet<>();
        int deletions = 0;

        for (int f : freq) {
            while (f > 0 && used.contains(f)) {
                f--;
                deletions++;
            }
            used.add(f);
        }

        return deletions;
    }
}