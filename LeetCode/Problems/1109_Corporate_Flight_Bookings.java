class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int answer[] = new int[n];
        int len = bookings.length;
        for (int i = 0; i < len; i++) {
            int first = bookings[i][0];
            int last = bookings[i][1];
            int seats = bookings[i][2];
            answer[first - 1] += seats;
            if (last < n) {
                answer[last] -= seats;
            }
        }
        for (int i = 1; i < n; i++) {
            answer[i] += answer[i - 1];
        }
        return answer;
    }
}