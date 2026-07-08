class Solution {
    int map[];
    int validIdx;

    public int validIndex() {
        while (validIdx > 0) {
            if (map[validIdx] == 0) {
                return validIdx;
            }
            validIdx--;
        }
        return 0;
    }

    public int minDeletions(String s) {
        int n = s.length();
        int freq[] = new int[26];
        validIdx = 100000;
        for (int i = 0; i < n; i++) {
            int curr = s.charAt(i) - 'a';
            freq[curr]++;
        }
        map = new int[100001];
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                map[freq[i]]++;
            }
        }
        int ans = 0;
        for (int i = 100000; i > 0; i--) {
            validIdx = Math.min(validIdx, i - 1);
            if (map[i] > 1) {
                int j = map[i] - 1;
                while (j > 0) {
                    int idx = validIndex();
                    map[idx] = 1;
                    ans += (i - idx);
                    j--;
                }
            }
        }
        return ans;
    }
}