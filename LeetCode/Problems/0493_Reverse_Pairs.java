class Solution {
    int reversePairs = 0;

    public void partition(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        partition(nums, left, mid);
        partition(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    public void merge(int[] nums, int left, int mid, int right) {
        int j = mid + 1;
        int i = left;
        while (i <= mid) {
            while (j <= right && nums[i] > 2L * nums[j]) {
                j++;
            }
            reversePairs += j - (mid + 1);
            i++;
        }

        i = left;
        j = mid + 1;
        int[] newArray = new int[right - left + 1];
        int k = 0;

        while (i <= mid && j <= right) {

            if (nums[i] <= nums[j]) {
                newArray[k++] = nums[i++];
            } else {
                newArray[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            newArray[k++] = nums[i++];
        }

        while (j <= right) {
            newArray[k++] = nums[j++];
        }

        for (int x = 0; x < newArray.length; x++) {
            nums[x + left] = newArray[x];
        }
    }

    public int reversePairs(int[] nums) {
        partition(nums, 0, nums.length - 1);
        return reversePairs;
    }
}