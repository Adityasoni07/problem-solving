class Solution {
    public int minimumCardPickup(int[] cards) {
        int[] idx = new int[1000001];
        int ans = 1000001;
        for (int i = 0; i < cards.length; i++) {
            if (idx[cards[i]] != 0) {
                ans = Math.min(ans, i - idx[cards[i]] + 2);
                if (ans == 1) {
                    return 1;
                }
            }
            idx[cards[i]] = i + 1;
        }
        if (ans == 1000001) {
            return -1;
        }
        return ans;
    }
}