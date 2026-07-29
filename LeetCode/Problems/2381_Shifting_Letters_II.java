class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int diff[] = new int[n + 1];

        for (int i = 0; i < shifts.length; i++) {
            int l = shifts[i][0];
            int r = shifts[i][1];
            int dir = shifts[i][2];

            if (dir == 1) {
                diff[l] += 1;
                diff[r + 1] -= 1;
            } else {
                diff[l] -= 1;
                diff[r + 1] += 1;
            }
        }

        for (int i = 1; i < n; i++) {
            diff[i] += diff[i - 1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char curr = s.charAt(i);
            int shift = diff[i] % 26;
            if (shift < 0) {
                shift += 26;
            }
            int newChar = (curr - 'a' + shift) % 26;
            sb.append((char) (newChar + 'a'));
        }

        return sb.toString();
    }
}