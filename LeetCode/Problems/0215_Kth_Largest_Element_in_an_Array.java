class Solution {
    public int[] sortArray(int nums[], int k, int left, int right) {
        if (left >= right) {
            return new int[] { nums[left] };
        }
        int mid = left + (right - left) / 2;
        int leftArray[] = sortArray(nums, k, left, mid);
        int rightArray[] = sortArray(nums, k, mid + 1, right);
        return merge(leftArray, rightArray, k);
    }

    public int[] merge(int leftArray[], int rightArray[], int k) {
        int m = leftArray.length;
        int n = rightArray.length;
        int len = m + n;
        if (k < m + n) {
            len = k;
        }
        int newArray[] = new int[len];
        int i = 0;
        int j = 0;
        int idx = 0;
        while (idx < k && i < m && j < n) {
            if (leftArray[i] >= rightArray[j]) {
                newArray[idx] = leftArray[i];
                i++;
            } else {
                newArray[idx] = rightArray[j];
                j++;
            }
            idx++;
        }
        while (idx < k && i < m) {
            newArray[idx] = leftArray[i];
            i++;
            idx++;
        }
        while (idx < k && j < n) {
            newArray[idx] = rightArray[j];
            j++;
            idx++;
        }
        return newArray;
    }

    public int findKthLargest(int[] nums, int k) {
        int[] sortedArray = sortArray(nums, k, 0, nums.length - 1);
        return sortedArray[sortedArray.length - 1];
    }
}