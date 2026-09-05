class Solution {
    boolean used[];
    int kth;
    String ans;

    public boolean backtrack(int nums[], int k, StringBuilder path) {

        if (path.length() == nums.length) {
            kth++;

            if (kth == k) {
                ans = path.toString();
                return true;
            }

            return false;
        }

        for (int i = 0; i < nums.length; i++) {

            if (!used[i]) {
                used[i] = true;
                path.append(nums[i]);

                if (backtrack(nums, k, path)) {
                    return true;
                }

                used[i] = false;
                path.deleteCharAt(path.length() - 1);
            }
        }

        return false;
    }

    public String getPermutation(int n, int k) {
        ans = "";
        kth = 0;

        used = new boolean[n];

        int nums[] = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        backtrack(nums, k, new StringBuilder());

        return ans;
    }
}