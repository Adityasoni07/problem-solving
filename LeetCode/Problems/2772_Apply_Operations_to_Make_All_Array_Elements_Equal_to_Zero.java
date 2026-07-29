class Solution {
    public boolean checkArray(int[] nums, int k) {
        int n = nums.length;
        int diff[] = new int[n];
        int prev = 0;
        for (int i = 0; i < n; i++) {
            diff[i] += prev;

            if (nums[i] < diff[i])
                return false;

            if (nums[i] > diff[i]) {

                if (i + k > n)
                    return false;

                int need = nums[i] - diff[i];

                diff[i] += need;
                if (k + i < n) {
                    diff[k + i] -= need;
                }
            }

            prev = diff[i];
        }
        return true;
    }
}