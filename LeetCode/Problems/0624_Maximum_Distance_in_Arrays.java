import java.util.List;

class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int min1 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max2 = Integer.MIN_VALUE;
        int minIth = -1;
        int maxIth = -1;
        int m = arrays.size();
        for (int i = 0; i < m; i++) {
            List<Integer> list = arrays.get(i);
            int n = list.size();
            if (min1 >= list.get(0)) {
                min2 = min1;
                min1 = list.get(0);
                minIth = i;
            } else if (min2 >= list.get(0)) {
                min2 = list.get(0);
            }
            if (max1 <= list.get(n - 1)) {
                max2 = max1;
                max1 = list.get(n - 1);
                maxIth = i;
            } else if (max2 <= list.get(n - 1)) {
                max2 = list.get(n - 1);
            }
        }
        if (minIth != maxIth) {
            return max1 - min1;
        } else {
            return Math.max(max1 - min2, max2 - min1);
        }
    }
}