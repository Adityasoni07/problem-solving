class Solution {
    public int takeCharacters(String s, int k) {
        int arr[] = new int[3];
        int A = 0;
        int B = 1;
        int C = 2;
        int n = s.length();
        int left = 0;
        int ans = 100001;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            arr[c - 'a']++;
        }

        if (arr[0] < k || arr[1] < k || arr[2] < k) {
            return -1;
        }

        for (int right = 0; right < n; right++) {
            int curr = s.charAt(right) - 'a';
            arr[curr]--;
            while (left <= right && (arr[A] < k || arr[B] < k || arr[C] < k)) {
                int leftChar = s.charAt(left) - 'a';
                arr[leftChar]++;
                left++;
            }
            ans = Math.min(ans, n - (right - left + 1));
        }
        return ans;
    }
}