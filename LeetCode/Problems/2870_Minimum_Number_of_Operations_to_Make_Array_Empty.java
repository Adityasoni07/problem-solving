import java.util.HashMap;

class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int ans = 0;
        for (int num : map.keySet()) {
            int curr = map.get(num);
            if (curr == 1) {
                return -1;
            } else {
                ans += curr / 3;
                if (curr % 3 == 2 || curr % 3 == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }
}