class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0, len = 0, m = nums1.length, n = nums2.length;
        double arr[] = new double[m + n];
        double median = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                arr[len] = nums1[i];
                i++;
            } else {
                arr[len] = nums2[j];
                j++;
            }
            len++;
        }
        while (i < m) {
            arr[len] = nums1[i];
            i++;
            len++;
        }
        while (j < n) {
            arr[len] = nums2[j];
            j++;
            len++;
        }
        if ((m + n) % 2 == 0) {
            median = (arr[len / 2] + arr[(len / 2) - 1]) / 2;
        } else {
            median = arr[len / 2];
        }
        return median;
    }
}