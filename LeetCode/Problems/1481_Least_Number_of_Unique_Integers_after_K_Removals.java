import java.util.HashMap;

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int[] freq = new int[100001];
        int unique = map.size();
        for (int num : map.keySet()) {
            freq[map.get(num)]++;
        }
        int tempK = k;
        for (int i = 1; i <= arr.length && tempK > 0; i++) {
            if (freq[i] == 0)
                continue;

            int remove = Math.min(freq[i], tempK / i);

            unique -= remove;
            tempK -= remove * i;
        }
        return unique;
    }
}