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

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftminDepth = minDepth(root.left);
        int rightminDepth = minDepth(root.right);
        int temp = 0;
        if (leftminDepth == 0 || rightminDepth == 0) {
            temp = Math.max(leftminDepth, rightminDepth);
        } else {
            temp = Math.min(leftminDepth, rightminDepth);
        }
        return temp + 1;
    }
}