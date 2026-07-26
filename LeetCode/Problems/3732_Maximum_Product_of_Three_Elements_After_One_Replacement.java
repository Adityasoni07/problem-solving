class Solution {
    public long maxProduct(int[] nums) {
        int min1 = 100001;
        int min2 = 100001;
        int max1 = -100001;
        int max2 = -100001;

        for (int curr : nums) {
            if (curr >= max1) {
                max2 = max1;
                max1 = curr;
            } else if (curr > max2) {
                max2 = curr;
            }

            if (curr <= min1) {
                min2 = min1;
                min1 = curr;
            } else if (curr < min2) {
                min2 = curr;
            }
        }

        long option1 = Math.abs((long) min1 * min2 * 100000);
        long option2 = Math.abs((long) max1 * max2 * 100000);
        long option3 = Math.abs((long) min1 * max1 * 100000);

        return Math.max(option1, Math.max(option2, option3));
    }
}