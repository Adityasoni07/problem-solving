class Solution {
    public int minimumRecolors(String blocks, int k) {
        int white = 0;
        int ans = k;

        for (int right = 0; right < blocks.length(); right++) {

            if (blocks.charAt(right) == 'W') {
                white++;
            }

            if (right >= k - 1) {
                ans = Math.min(ans, white);
                if (ans == 0) {
                    return 0;
                }
                if (blocks.charAt(right - k + 1) == 'W') {
                    white--;
                }
            }
        }

        return ans;
    }
}