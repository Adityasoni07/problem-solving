class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int freq[] = new int[3];
        int ans = 0;
        int unique = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            int curr = s.charAt(right) - 'a';
            freq[curr]++;
            if (freq[curr] == 1) {
                unique++;
            }
            while (unique == 3) {
                ans = ans + (n - right);
                int temp = s.charAt(left) - 'a';
                freq[temp]--;
                if (freq[temp] == 0) {
                    unique--;
                }
                left++;
            }
        }
        return ans;
    }
}