import java.util.*;

class Solution {
    List<List<Integer>> ans;

    public void solve(int[] candidates, int target, int i, List<Integer> curr) {
        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if (i == candidates.length || target < 0) {
            return;
        }
        curr.add(candidates[i]);
        solve(candidates, target - candidates[i], i, curr);
        curr.remove(curr.size() - 1);
        solve(candidates, target, i + 1, curr);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        solve(candidates, target, 0, new ArrayList<>());
        return ans;
    }
}