class Solution {
    public double myPow(double x, int n) {
        double ans;
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }

        ans = myPow(x, n / 2);

        if (n % 2 == 0) {
            ans = ans * ans;
        } else if (n < 0) {
            ans = (1 / x) * ans * ans;
        } else {
            ans = x * ans * ans;
        }

        return ans;
    }
}