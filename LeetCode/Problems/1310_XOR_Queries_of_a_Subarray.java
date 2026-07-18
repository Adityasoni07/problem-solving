class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int prefix[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] ^ arr[i - 1];
        }
        int len = queries.length;
        int answer[] = new int[len];
        for (int i = 0; i < len; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            answer[i] = prefix[left] ^ prefix[right + 1];
        }
        return answer;
    }
}