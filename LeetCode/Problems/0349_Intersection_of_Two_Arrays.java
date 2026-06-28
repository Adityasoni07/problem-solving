class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] count = new int[1001];
        for (int num : nums1) {
            count[num] = 1;
        }
        int n = 0;
        for (int num : nums2) {
            if (count[num] == 1) {
                count[num] = 2;
                n++;
            }
        }
        int[] ans = new int[n];
        int idx = 0;
        for (int i = 0; i < 1001; i++) {
            if (count[i] == 2) {
                ans[idx] = i;
                idx++;
            }
        }
        return ans;
    }
}