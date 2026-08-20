import java.util.*;

class Solution {
    List<List<Integer>> ans;

    public void solve(int[] nums, int start, List<Integer> curr) {
        ans.add(new ArrayList<>(curr));
        for (int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            solve(nums, i + 1, curr);
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        solve(nums, 0, new ArrayList<>());
        return ans;
    }
}