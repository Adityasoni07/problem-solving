class Solution {

    private int currentOR = 0;

    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int[] bitCount = new int[32];

        int left = 0;
        int currentOR = 0;
        int ans = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {

            currentOR = add(bitCount, nums[right], currentOR);

            while (left <= right && currentOR >= k) {
                ans = Math.min(ans, right - left + 1);

                currentOR = remove(bitCount, nums[left], currentOR);
                left++;
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int add(int[] bitCount, int num, int currentOR) {
        for (int b = 0; b < 32; b++) {
            if ((num & (1 << b)) != 0) {
                bitCount[b]++;

                if (bitCount[b] == 1) {
                    currentOR |= (1 << b);
                }
            }
        }
        return currentOR;
    }

    private int remove(int[] bitCount, int num, int currentOR) {
        for (int b = 0; b < 32; b++) {
            if ((num & (1 << b)) != 0) {
                bitCount[b]--;

                if (bitCount[b] == 0) {
                    currentOR &= ~(1 << b);
                }
            }
        }
        return currentOR;
    }
}