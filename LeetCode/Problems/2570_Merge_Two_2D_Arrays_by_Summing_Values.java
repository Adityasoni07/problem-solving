import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        List<int[]> list = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (nums1[i][0] == nums2[j][0]) {

                nums1[i][1] += nums2[j][1];
                list.add(nums1[i]);
                i++;
                j++;
            }

            else if (nums1[i][0] > nums2[j][0]) {
                list.add(nums2[j]);
                j++;
            } else {

                list.add(nums1[i]);
                i++;
            }
        }

        while (i < m) {
            list.add(nums1[i]);
            i++;
        }

        while (j < n) {
            list.add(nums2[j]);
            j++;
        }

        int[][] result = list.toArray(new int[list.size()][]);
        return result;
    }
}