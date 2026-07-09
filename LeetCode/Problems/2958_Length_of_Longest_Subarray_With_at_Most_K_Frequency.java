import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, ans = 0;

        for (int right = 0; right < nums.length; right++) {
            int x = nums[right];
            map.put(x, map.getOrDefault(x, 0) + 1);
            while (map.get(x) > k) {
                int val = nums[left];
                map.put(val, map.get(val) - 1);
                if (map.get(val) == 0) {
                    map.remove(val);
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}