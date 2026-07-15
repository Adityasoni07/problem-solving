import java.util.HashMap;
import java.util.List;

class Solution {
    public long maxSum(List<Integer> nums, int m, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        long ans = 0;
        long sum = 0;
        int n = nums.size();
        for (int right = 0; right < n; right++) {
            int curr = nums.get(right);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
            sum += curr;
            if (right >= k - 1) {
                if (map.size() >= m) {
                    ans = Math.max(ans, sum);
                }
                int currLeft = nums.get(right - k + 1);
                map.put(currLeft, map.getOrDefault(currLeft, 0) - 1);
                sum -= currLeft;
                if (map.get(currLeft) == 0) {
                    map.remove(currLeft);
                }
            }
        }
        return ans;
    }
}