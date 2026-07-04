class Solution {
    public int countPairs(int[] deliciousness) {
        int MOD = 1_000_000_007;
        int power[] = new int[22];
        power[0] = 1;
        for (int i = 1; i < 22; i++) {
            power[i] = power[i - 1] << 1;
        }
        int ans = 0;
        int max = 1 << 20;
        int freq[] = new int[max + 1];
        for (int food : deliciousness) {
            for (int i = 0; i < 22; i++) {
                int need = power[i] - food;
                if (need >= 0 && need <= max) {
                    ans = (ans + freq[need]) % MOD;
                }
            }
            freq[food]++;
        }
        return (int) ans;
    }
}