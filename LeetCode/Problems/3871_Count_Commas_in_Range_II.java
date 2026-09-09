class Solution {
    public long countCommas(long n) {
        long num1 = 1000;
        long num2 = 10000;
        int zeros = 3;
        long ans = 0;
        while (num1 <= n) {
            long end = Math.min(num2 - 1, n);
            long temp = end - num1 + 1;
            ans = ans + (zeros / 3) * temp;

            num1 = num2;
            num2 = num2 * 10;
            zeros++;
        }
        if (num1 <= n) {
            ans = ans + (n - num1 + 1) * (zeros / 3);
        }
        return ans;
    }
}