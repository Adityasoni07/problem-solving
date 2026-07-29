class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] arr = new int[1001];
        for (int i = 0; i < trips.length; i++) {
            arr[trips[i][1]] = arr[trips[i][1]] + trips[i][0];
            arr[trips[i][2]] = arr[trips[i][2]] - trips[i][0];
        }
        int i = 0;
        while (capacity >= 0 && i < 1001) {
            capacity = capacity - arr[i];
            i++;
        }
        return capacity >= 0;
    }
}