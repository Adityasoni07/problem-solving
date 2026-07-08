/*

🔹 Intuition (LC 1423)

At first, it looks like a "pick from left/right" problem.

Instead of thinking:
→ Pick k cards.

Think:
→ Leave n - k cards.

Why?
After picking cards only from the two ends, the remaining cards are always one contiguous subarray.

So:
Maximum Score
= Total Sum − Minimum Sum Subarray of Length (n − k)

This transforms the problem into a Fixed Size Sliding Window.

*/

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int totalScore = 0;
        int windowSum = 0;
        int windowSize = n - k;
        for (int i = 0; i < n; i++) {
            totalScore += cardPoints[i];
            if (i < windowSize) {
                windowSum += cardPoints[i];
            }
        }
        if (windowSize == 0) {
            return totalScore;
        }
        int maxScore = 0;
        for (int right = windowSize; right < n; right++) {
            maxScore = Math.max(totalScore - windowSum, maxScore);
            windowSum += cardPoints[right];
            windowSum -= cardPoints[right - windowSize];
        }
        return Math.max(totalScore - windowSum, maxScore);
    }
}