import java.util.HashMap;

class Solution {
    public int longestWPI(int[] hours) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int longest = 0;
        int prefix = 0;
        for (int i = 0; i < hours.length; i++) {
            if (hours[i] > 8) {
                prefix++;
            } else {
                prefix--;
            }
            if (prefix > 0) {
                longest = i + 1;
            } else {
                if (map.containsKey(prefix - 1)) {
                    longest = Math.max(longest, i - map.get(prefix - 1));
                }
            }
            map.putIfAbsent(prefix, i);
        }
        return longest;
    }
}