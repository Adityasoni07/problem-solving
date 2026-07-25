import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestAwesome(String s) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int mask = 0;
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {

            int digit = s.charAt(i) - '0';
            mask ^= (1 << digit);

            if (map.containsKey(mask)) {
                ans = Math.max(ans, i - map.get(mask));
            }

            for (int bit = 0; bit < 10; bit++) {
                int newMask = mask ^ (1 << bit);
                if (map.containsKey(newMask)) {
                    ans = Math.max(ans, i - map.get(newMask));
                }
            }

            map.putIfAbsent(mask, i);
        }
        return ans;
    }
}