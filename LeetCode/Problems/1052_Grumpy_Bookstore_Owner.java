class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int satisfied = 0;

        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                satisfied += customers[i];
            }
        }

        int extraSatisfied = 0;
        int maxExtraSatisfied = 0;

        for (int right = 0; right < n; right++) {
            if (grumpy[right] == 1) {
                extraSatisfied += customers[right];
            }

            if (right >= minutes && grumpy[right - minutes] == 1) {
                extraSatisfied -= customers[right - minutes];
            }

            maxExtraSatisfied = Math.max(maxExtraSatisfied, extraSatisfied);
        }

        return satisfied + maxExtraSatisfied;
    }
}