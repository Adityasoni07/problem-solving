class NumMatrix {
    int arr[][];

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        arr = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            arr[i + 1][1] = matrix[i][0];
            for (int j = 1; j < n; j++) {
                arr[i + 1][j + 1] = arr[i + 1][j] + matrix[i][j];
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 2; j < m + 1; j++) {
                arr[j][i] = arr[j][i] + arr[j - 1][i];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int rCorner = arr[row2 + 1][col2 + 1];
        int lCorner = arr[row1][col1];
        int temp = arr[row2 + 1][col1] + arr[row1][col2 + 1];
        return rCorner + lCorner - temp;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */