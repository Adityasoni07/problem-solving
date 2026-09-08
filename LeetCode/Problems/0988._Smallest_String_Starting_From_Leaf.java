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

    String smallest = "{";

    public void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }

        sb.append((char) ('a' + root.val));

        if (root.left == null && root.right == null) {
            String s = sb.reverse().toString();
            if (s.compareTo(smallest) < 0) {
                smallest = s;
            }
            sb.reverse();
            sb.deleteCharAt(sb.length() - 1);

            return;
        }

        dfs(root.left, sb);
        dfs(root.right, sb);

        sb.deleteCharAt(sb.length() - 1);
    }

    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return smallest;
    }
}