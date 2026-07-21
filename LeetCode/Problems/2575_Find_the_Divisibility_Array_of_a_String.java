class Solution {
    public int[] divisibilityArray(String word, int m) {
        int n = word.length();
        int ans[] = new int[n];
        long remainder = 0;
        for (int i = 0; i < n; i++) {
            int curr = word.charAt(i) - '0';
            remainder = (remainder * 10 + curr) % m;
            if (remainder == 0) {
                ans[i] = 1;
            }
        }
        return ans;
    }
}