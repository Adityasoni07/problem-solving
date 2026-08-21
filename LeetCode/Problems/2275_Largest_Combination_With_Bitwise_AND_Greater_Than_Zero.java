class Solution {
    public int largestCombination(int[] candidates) {
        int ans = 0;
        int n = candidates.length;
        int freq[] = new int[32];
        for (int i = 0; i < n; i++) {
            int curr = candidates[i];
            int idx = 0;
            while (curr != 0) {
                if ((curr & 1) == 1) {
                    freq[idx]++;
                }
                idx++;
                curr = curr >> 1;
            }
        }
        for (int i = 0; i < 32; i++) {
            ans = Math.max(ans, freq[i]);
        }
        return ans;
    }
}