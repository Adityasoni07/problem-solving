import java.util.*;

class Solution {
    List<List<Integer>> ans;
    boolean used[];

    public void backtrack(int nums[], List<Integer> path) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                path.add(nums[i]);
                backtrack(nums, path);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        used = new boolean[nums.length];
        backtrack(nums, new ArrayList<>());
        return ans;
    }
}