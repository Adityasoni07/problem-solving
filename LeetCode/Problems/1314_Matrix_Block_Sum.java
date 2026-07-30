class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] prefix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int curr = mat[i][j];

                if (i > 0) {
                    curr += prefix[i - 1][j];
                }

                if (j > 0) {
                    curr += prefix[i][j - 1];
                }

                if (i > 0 && j > 0) {
                    curr -= prefix[i - 1][j - 1];
                }

                prefix[i][j] = curr;
            }
        }

        int[][] answer = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int r1 = Math.max(0, i - k);
                int c1 = Math.max(0, j - k);
                int r2 = Math.min(m - 1, i + k);
                int c2 = Math.min(n - 1, j + k);

                int curr = prefix[r2][c2];

                if (r1 > 0) {
                    curr -= prefix[r1 - 1][c2];
                }

                if (c1 > 0) {
                    curr -= prefix[r2][c1 - 1];
                }

                if (r1 > 0 && c1 > 0) {
                    curr += prefix[r1 - 1][c1 - 1];
                }

                answer[i][j] = curr;
            }
        }

        return answer;
    }
}