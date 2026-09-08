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

    int ans;

    public void dfs(TreeNode root, int n) {
        if (root == null) {
            return;
        }

        n = (n << 1) | root.val;

        if (root.left == null && root.right == null) {
            ans += n;
            return;
        }

        dfs(root.left, n);
        dfs(root.right, n);
    }

    public int sumRootToLeaf(TreeNode root) {
        ans = 0;
        dfs(root, 0);
        return ans;
    }

}