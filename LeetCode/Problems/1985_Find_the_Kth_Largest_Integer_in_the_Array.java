class Solution {
    public String[] sortArray(String nums[], int k, int left, int right) {
        if (left >= right) {
            return new String[] { nums[left] };
        }
        int mid = left + (right - left) / 2;
        String leftArray[] = sortArray(nums, k, left, mid);
        String rightArray[] = sortArray(nums, k, mid + 1, right);
        return merge(leftArray, rightArray, k);
    }

    public String[] merge(String leftArray[], String rightArray[], int k) {
        int m = leftArray.length;
        int n = rightArray.length;
        int len = m + n;
        if (k < m + n) {
            len = k;
        }
        String newArray[] = new String[len];
        int i = 0;
        int j = 0;
        int idx = 0;
        while (idx < k && i < m && j < n) {
            String bigNum;
            if (leftArray[i].length() == rightArray[j].length()) {
                if (leftArray[i].compareTo(rightArray[j]) < 0) {
                    bigNum = rightArray[j];
                    j++;
                } else {
                    bigNum = leftArray[i];
                    i++;
                }
            } else if (leftArray[i].length() > rightArray[j].length()) {
                bigNum = leftArray[i];
                i++;
            } else {
                bigNum = rightArray[j];
                j++;
            }
            newArray[idx] = bigNum;
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

    public String kthLargestNumber(String[] nums, int k) {
        String[] sortedArray = sortArray(nums, k, 0, nums.length - 1);
        String kth = sortedArray[sortedArray.length - 1];
        return kth;
    }
}
