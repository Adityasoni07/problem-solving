class Solution {
    int lower;
    int upper;
    long rangeSum;

    public void partition(long[] prefix, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        partition(prefix, left, mid);
        partition(prefix, mid + 1, right);
        merge(prefix, left, mid, right);
    }

    public void merge(long[] prefix, int left, int mid, int right) {
        int low = mid + 1;
        int high = mid + 1;

        for (int k = left; k <= mid; k++) {

            long lowerBound = (long) prefix[k] + lower;
            long upperBound = (long) prefix[k] + upper;

            while (low <= right && prefix[low] < lowerBound) {
                low++;
            }

            while (high <= right && prefix[high] <= upperBound) {
                high++;
            }

            rangeSum += high - low;
        }

        int i = left;
        int j = mid + 1;
        long[] newArray = new long[right - left + 1];
        int k = 0;

        while (i <= mid && j <= right) {
            if (prefix[i] <= prefix[j]) {
                newArray[k++] = prefix[i++];
            } else {
                newArray[k++] = prefix[j++];
            }
        }

        while (i <= mid) {
            newArray[k++] = prefix[i++];
        }

        while (j <= right) {
            newArray[k++] = prefix[j++];
        }

        for (int x = 0; x < newArray.length; x++) {
            prefix[x + left] = newArray[x];
        }

    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
        rangeSum = 0;
        long prefix[] = new long[nums.length + 1];
        prefix[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        partition(prefix, 0, nums.length);
        return (int) rangeSum;
    }
}