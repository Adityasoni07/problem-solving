class Solution {
    public int maxArea(int[] height) {
        int L = 0, R = height.length - 1, w, h, mostWater = -1;
        while (L < R) {
            w = R - L;
            if (height[L] < height[R]) {
                h = height[L];
                L++;
            } else {
                h = height[R];
                R--;
            }
            int totalWater = h * w;
            if (totalWater > mostWater) {
                mostWater = totalWater;
            }
        }
        return mostWater;
    }
}