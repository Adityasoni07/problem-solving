class Solution {
    public int reverse(int x) {
        int r, ith = 1, rev = 0;
        long temp = 0;
        while (x != 0) {
            r = x % 10;
            x = x / 10;
            temp = (temp * 10) + r;
        }
        if (temp < -2147483648 || temp > 2147483647) {
            rev = 0;
        } else {
            rev = (int) temp;
        }
        return rev;
    }
}