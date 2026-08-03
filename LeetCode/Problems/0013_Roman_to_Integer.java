class Solution {
    public int romanToInt(String s) {
        int arr[] = new int[26];
        arr['I' - 'A'] = 1;
        arr['V' - 'A'] = 5;
        arr['X' - 'A'] = 10;
        arr['L' - 'A'] = 50;
        arr['C' - 'A'] = 100;
        arr['D' - 'A'] = 500;
        arr['M' - 'A'] = 1000;
        int i = 0, ans = 0;
        while (i < s.length() - 1) {
            if (arr[s.charAt(i) - 'A'] >= arr[s.charAt(i + 1) - 'A']) {
                ans = ans + arr[s.charAt(i) - 'A'];
                i++;
            } else {
                ans = ans + arr[s.charAt(i + 1) - 'A'] - arr[s.charAt(i) - 'A'];
                i += 2;
            }

        }
        if (i < s.length()) {
            ans = ans + arr[s.charAt(i) - 'A'];
        }
        return ans;
    }
}