import java.util.HashMap;

class Solution {
    public int[] countWordOccurrences(String[] chunks, String[] queries) {
        StringBuilder sb = new StringBuilder();
        for (String chunk : chunks) {
            sb.append(chunk);
        }
        String s = sb.toString();
        int n = s.length();
        HashMap<String, Integer> map = new HashMap<>();
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                word.append(c);
            } else if (c == '-' && i > 0 && i < s.length() - 1 && Character.isLowerCase(s.charAt(i - 1))
                    && Character.isLowerCase(s.charAt(i + 1))) {
                word.append(c);
            } else {
                if (word.length() > 0) {
                    map.put(word.toString(), map.getOrDefault(word.toString(), 0) + 1);
                    word.setLength(0);
                }
            }
        }
        if (word.length() > 0) {
            map.put(word.toString(), map.getOrDefault(word.toString(), 0) + 1);
        }
        int ans[] = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = map.getOrDefault(queries[i], 0);
        }
        return ans;
    }
}