class Solution {
    public int maxSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] prefix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int curr = grid[i][j];

                if (i > 0)
                    curr += prefix[i - 1][j];

                if (j > 0)
                    curr += prefix[i][j - 1];

                if (i > 0 && j > 0)
                    curr -= prefix[i - 1][j - 1];

                prefix[i][j] = curr;
            }
        }

        int ans = Integer.MIN_VALUE;

        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {

                int r1 = i - 1;
                int c1 = j - 1;
                int r2 = i + 1;
                int c2 = j + 1;

                int curr = prefix[r2][c2];

                if (r1 > 0)
                    curr -= prefix[r1 - 1][c2];

                if (c1 > 0)
                    curr -= prefix[r2][c1 - 1];

                if (r1 > 0 && c1 > 0)
                    curr += prefix[r1 - 1][c1 - 1];

                curr -= grid[i][j - 1];
                curr -= grid[i][j + 1];

                ans = Math.max(ans, curr);
            }
        }

        return ans;
    }
}