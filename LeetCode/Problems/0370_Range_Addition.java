class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] diff = new int[length];

        for (int[] update : updates) {
            int startIndex = update[0];
            int endIndex = update[1];
            int increment = update[2];

            diff[startIndex] += increment;

            if (endIndex + 1 < length) {
                diff[endIndex + 1] -= increment;
            }
        }

        for (int i = 1; i < length; i++) {
            diff[i] += diff[i - 1];
        }

        return diff;
    }
}