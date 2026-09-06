import java.util.*;

class Solution {
    int counts[];

    public void partition(int nums[], int[] index, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        partition(nums, index, left, mid);
        partition(nums, index, mid + 1, right);
        merge(nums, index, left, mid, right);
    }

    public void merge(int nums[], int[] index, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = 0;
        int[] newArr = new int[right - left + 1];
        int rightSmallerCount = 0;
        while (i <= mid && j <= right) {
            if (nums[index[i]] > nums[index[j]]) {
                newArr[k++] = index[j++];
                rightSmallerCount++;
            } else {
                newArr[k++] = index[i];
                counts[index[i]] += rightSmallerCount;
                i++;
            }
        }
        while (i <= mid) {
            newArr[k++] = index[i];
            counts[index[i]] += rightSmallerCount;
            i++;
        }
        while (j <= right) {
            newArr[k++] = index[j++];
        }

        for (int x = 0; x < newArr.length; x++) {
            index[left + x] = newArr[x];
        }

    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        counts = new int[n];
        int[] index = new int[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        partition(nums, index, 0, n - 1);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.add(counts[i]);
        }
        return ans;
    }
}