import java.util.HashMap;

class Solution {
    public int findTheLongestSubstring(String s) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int state = 0;
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                state ^= (1 << 0);
            } else if (c == 'e') {
                state ^= (1 << 1);
            } else if (c == 'i') {
                state ^= (1 << 2);
            } else if (c == 'o') {
                state ^= (1 << 3);
            } else if (c == 'u') {
                state ^= (1 << 4);
            }
            if (map.containsKey(state)) {
                ans = Math.max(ans, i - map.get(state));
            } else {
                map.put(state, i);
            }
        }
        return ans;
    }
}