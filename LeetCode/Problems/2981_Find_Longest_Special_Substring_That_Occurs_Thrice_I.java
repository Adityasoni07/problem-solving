import java.util.HashMap;

class Solution {
    public int maximumLength(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        int n = s.length();
        int left = 0;

        while (left < n) {
            int right = left;

            while (right < n && s.charAt(right) == s.charAt(left)) {
                right++;
            }

            int len = right - left;
            for (int size = 1; size <= len; size++) {
                int occur = len - size + 1;
                String key = s.substring(left, left + size);
                map.put(key, map.getOrDefault(key, 0) + occur);
            }
            left = right;
        }

        int ans = -1;
        for (String key : map.keySet()) {
            if (map.get(key) >= 3) {
                ans = Math.max(ans, key.length());
            }
        }

        return ans;
    }
}