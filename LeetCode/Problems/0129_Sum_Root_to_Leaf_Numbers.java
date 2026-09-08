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

    int sum = 0;

    public void sum(TreeNode root, int num) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            num = (num * 10) + root.val;
            sum += num;
            return;
        }
        sum(root.left, (num * 10) + root.val);
        sum(root.right, (num * 10) + root.val);
    }

    public int sumNumbers(TreeNode root) {
        sum(root, 0);
        return sum;
    }
}