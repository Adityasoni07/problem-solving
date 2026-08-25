class Solution {
    public int missingMultiple(int[] nums, int k) {
        int map[] = new int[(100 / k) + 1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % k == 0) {
                map[nums[i] / k]++;
            }
        }
        int j = 1;
        while (j < map.length) {
            if (map[j] == 0) {
                return j * k;
            }
            j++;
        }
        return j * k;
    }
}