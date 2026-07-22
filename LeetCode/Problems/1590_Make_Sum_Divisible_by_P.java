import java.util.HashMap;

class Solution {
    public int minSubarray(int[] nums, int p) {
        long total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        int remainder = (int) (total % p);
        if (remainder == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int subarrayLen = nums.length;
        long prefix = 0;
        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            int currentMod = (int) (prefix % p);

            int target = (currentMod - remainder + p) % p;

            if (map.containsKey(target)) {
                subarrayLen = Math.min(subarrayLen, i - map.get(target));
            }
            map.put(currentMod, i);
        }
        if (subarrayLen == nums.length) {
            return -1;
        }
        return subarrayLen;
    }
}