class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int ans[][] = new int[n][n];
        for (int i = 0; i < queries.length; i++) {
            int r1 = queries[i][0];
            int c1 = queries[i][1];
            int r2 = queries[i][2];
            int c2 = queries[i][3];
            ans[r1][c1] += 1;
            if (r2 + 1 < n) {
                ans[r2 + 1][c1] -= 1;
            }
            if (c2 + 1 < n) {
                ans[r1][c2 + 1] -= 1;
            }
            if (r2 + 1 < n && c2 + 1 < n) {
                ans[r2 + 1][c2 + 1] += 1;
            }

        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int curr = ans[i][j];
                if (j - 1 >= 0) {
                    curr += ans[i][j - 1];
                }
                if (i - 1 >= 0) {
                    curr += ans[i - 1][j];
                }
                if (i - 1 >= 0 && j - 1 >= 0) {
                    curr -= ans[i - 1][j - 1];
                }
                ans[i][j] = curr;
            }
        }
        return ans;
    }
}