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
        count(pairArr, left, mid, right);
        merge(pairArr, left, mid, right);
    }

    public void count(Pair[] pairArr, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int rightSmallerCount = 0;

        while (i <= mid && j <= right) {
            if (pairArr[i].val > pairArr[j].val) {
                rightSmallerCount++;
                j++;
            } else {
                counts[pairArr[i].idx] += rightSmallerCount;
                i++;
            }
        }

        while (i <= mid) {
            counts[pairArr[i].idx] += rightSmallerCount;
            i++;
        }
    }

    public void merge(Pair[] pairArr, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = 0;
        Pair[] newPairArr = new Pair[right - left + 1];
        while (i <= mid && j <= right) {
            if (pairArr[i].val < pairArr[j].val) {
                newPairArr[k] = new Pair(pairArr[i].idx, pairArr[i].val);
                i++;
            } else {
                newPairArr[k] = new Pair(pairArr[j].idx, pairArr[j].val);
                j++;
            }
            k++;
        }
        while (i <= mid) {
            newPairArr[k] = new Pair(pairArr[i].idx, pairArr[i].val);
            i++;
            k++;
        }
        while (j <= right) {
            newPairArr[k] = new Pair(pairArr[j].idx, pairArr[j].val);
            j++;
            k++;
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