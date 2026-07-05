// Q2. Subsequence After One Replacement
// Medium

class Solution {
    public boolean canMakeSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();

        if (n > m)
            return false;

        int[] left = new int[n];
        int[] right = new int[n];

        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j < m && t.charAt(j) != s.charAt(i))
                j++;
            if (j == m)
                left[i] = -1;
            else {
                left[i] = j;
                j++;
            }
        }

        if (left[n - 1] != -1)
            return true;

        j = m - 1;
        for (int i = n - 1; i >= 0; i--) {
            while (j >= 0 && t.charAt(j) != s.charAt(i))
                j--;
            if (j < 0)
                right[i] = -1;
            else {
                right[i] = j;
                j--;
            }
        }

        for (int i = 0; i < n; i++) {
            int l = (i == 0) ? -1 : left[i - 1];
            int r = (i == n - 1) ? m : right[i + 1];

            if (l != -1 || i == 0) {
                if (r != -1 || i == n - 1) {
                    if (r > l + 1) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}