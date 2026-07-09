class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length();
        int left = 0;
        int maxCons = 0;
        int t = 0, f = 0;
        for (int right = 0; right < n; right++) {
            if (answerKey.charAt(right) == 'T') {
                t++;
            } else {
                f++;
            }
            while (Math.min(t, f) > k) {
                if (answerKey.charAt(left) == 'T') {
                    t--;
                } else {
                    f--;
                }
                left++;
            }
            maxCons = Math.max(maxCons, right - left + 1);
        }
        return maxCons;
    }
}