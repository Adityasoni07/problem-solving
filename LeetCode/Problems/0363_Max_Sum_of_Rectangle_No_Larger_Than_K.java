import java.util.*;

class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;

        int ans = Integer.MIN_VALUE;

        for (int top = 0; top < m; top++) {

            int[] compressed = new int[n];

            for (int bottom = top; bottom < m; bottom++) {

                for (int col = 0; col < n; col++) {
                    compressed[col] += matrix[bottom][col];
                }

                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                int prefix = 0;

                for (int x : compressed) {
                    prefix += x;

                    Integer prev = set.ceiling(prefix - k);

                    if (prev != null) {
                        ans = Math.max(ans, prefix - prev);
                    }

                    set.add(prefix);
                }
            }
        }

        return ans;
    }
}