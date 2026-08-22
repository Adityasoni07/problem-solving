class Solution {
    public boolean checkDivisibility(int n) {
        int temp = n;
        int sum = 0;
        int product = 1;
        while (temp != 0) {
            sum = sum + (temp % 10);
            product = product * (temp % 10);
            temp = temp / 10;
        }
        return n % (sum + product) == 0;
    }
}