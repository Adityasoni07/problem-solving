import java.util.*;

class Solution {
    public class Pair {
        int idx;
        int val;

        Pair(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }

    int counts[];

    public void partition(Pair[] pairArr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        partition(pairArr, left, mid);
        partition(pairArr, mid + 1, right);
        merge(pairArr, left, mid, right);
    }

    public void merge(Pair[] pairArr, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = 0;
        Pair[] newPairArr = new Pair[right - left + 1];
        int rightSmallerCount = 0;
        while (i <= mid && j <= right) {
            if (pairArr[i].val > pairArr[j].val) {
                newPairArr[k++] = pairArr[j++];
                rightSmallerCount++;
            } else {
                newPairArr[k++] = pairArr[i];
                counts[pairArr[i].idx] += rightSmallerCount;
                i++;
            }
        }
        while (i <= mid) {
            newPairArr[k++] = pairArr[i];
            counts[pairArr[i].idx] += rightSmallerCount;
            i++;
        }
        while (j <= right) {
            newPairArr[k++] = pairArr[j++];
        }

        for (int x = 0; x < newPairArr.length; x++) {
            pairArr[left + x] = newPairArr[x];
        }

    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        counts = new int[n];
        Pair[] pairArr = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairArr[i] = new Pair(i, nums[i]);
        }
        partition(pairArr, 0, n - 1);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.add(counts[i]);
        }
        return ans;
    }
}