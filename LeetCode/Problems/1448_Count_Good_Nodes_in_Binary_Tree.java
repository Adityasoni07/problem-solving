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

    public int findGoodNodes(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }
        int left = findGoodNodes(root.left, Math.max(root.val, max));
        int right = findGoodNodes(root.right, Math.max(root.val, max));
        if (max <= root.val) {
            return left + right + 1;
        }
        return left + right;
    }

    public int goodNodes(TreeNode root) {
        return findGoodNodes(root, Integer.MIN_VALUE);
    }
}