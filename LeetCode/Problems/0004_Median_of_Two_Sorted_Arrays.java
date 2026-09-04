class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (n < m) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int leftSize = (m + n + 1) / 2;
        int low = 0;
        int high = m;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int ALeft = Integer.MIN_VALUE;
            int ARight = Integer.MAX_VALUE;
            int BLeft = Integer.MIN_VALUE;
            int BRight = Integer.MAX_VALUE;
            if (mid > 0) {
                ALeft = nums1[mid - 1];
            }
            if (mid < m) {
                ARight = nums1[mid];
            }
            int rightmid = leftSize - mid;
            if (rightmid > 0) {
                BLeft = nums2[rightmid - 1];
            }
            if (rightmid < n) {
                BRight = nums2[rightmid];
            }
            if (ALeft <= BRight && BLeft <= ARight) {
                int leftMax  =  (Math.max(ALeft, BLeft));
                if ((m + n) % 2 == 1) {
                    return leftMax;
                }
                return (leftMax + Math.min(ARight, BRight)) / 2.0;
                
            } else if (ALeft > BRight) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return 0.0;
    }
}