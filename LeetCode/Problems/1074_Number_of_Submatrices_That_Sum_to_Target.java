import java.util.*;

class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            int compressed[] = new int[n];
            for (int j = i; j < m; j++) {
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                int sum = 0;
                for (int k = 0; k < n; k++) {
                    compressed[k] += matrix[j][k];
                    sum += compressed[k];
                    int need = sum - target;
                    ans = ans + map.getOrDefault(need, 0);
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }
        return ans;
    }
}