class Solution {
    public int maxProduct(int n) {
        int max1 = -1;
        int max2 = -1;
        int num = n;
        while (num != 0) {
            int currDigit = num % 10;
            if (max1 <= currDigit) {
                max2 = max1;
                max1 = currDigit;
            } else if (max2 <= currDigit) {
                max2 = currDigit;
            }
            num /= 10;
        }
        return max1 * max2;
    }
}