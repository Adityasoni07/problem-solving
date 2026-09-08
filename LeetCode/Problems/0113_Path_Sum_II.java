import java.util.*;

class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    List<List<Integer>> ans;

    public void find(TreeNode root, int targetSum, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (targetSum - root.val == 0) {
                list.add(root.val);
                ArrayList<Integer> l1 = new ArrayList<>();
                for (int i = 0; i < list.size(); i++) {
                    l1.add(list.get(i));
                }
                ans.add(l1);
                list.remove(list.size() - 1);
            }
            return;
        }
        list.add(root.val);
        find(root.left, targetSum - root.val, list);
        find(root.right, targetSum - root.val, list);
        list.remove(list.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        find(root, targetSum, new ArrayList<>());
        return ans;
    }
}