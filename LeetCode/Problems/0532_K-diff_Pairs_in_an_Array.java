import java.util.HashMap;

class Solution {
    public int findPairs(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int ans = 0;
        if (k == 0) {
            for (int freq : map.values()) {
                if (freq >= 2)
                    ans++;
            }
        } else {
            for (int num : map.keySet()) {
                if (map.containsKey(num + k))
                    ans++;
            }
        }

        return ans;
    }
}