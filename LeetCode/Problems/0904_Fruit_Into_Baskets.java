class Solution {
    public int totalFruit(int[] fruits) {
        int[] map = new int[fruits.length];
        int ans = 0;
        int left = 0;
        int type = 0;
        for (int right = 0; right < fruits.length; right++) {
            map[fruits[right]]++;
            if (map[fruits[right]] == 1) {
                type++;
            }
            while (type > 2) {
                map[fruits[left]]--;
                if (map[fruits[left]] == 0) {
                    type--;
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}