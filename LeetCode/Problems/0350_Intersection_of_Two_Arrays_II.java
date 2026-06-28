class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int count = 0;
        int[] arr1 = new int[1001];
        for (int i = 0; i < nums1.length; i++) {
            arr1[nums1[i]]++;
        }
        int[] arr2 = new int[1001];
        for (int i = 0; i < nums2.length; i++) {
            if (arr1[nums2[i]] > 0) {
                arr2[count] = nums2[i];
                arr1[nums2[i]]--;
                count++;
            }
        }
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = arr2[i];
        }
        return result;
    }
}