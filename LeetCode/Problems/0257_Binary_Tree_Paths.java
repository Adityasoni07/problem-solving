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

    List<String> list = new ArrayList<>();

    public void Paths(TreeNode root, StringBuilder sb) {

        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            sb.append(root.val);
            list.add(sb.toString());
        } else {
            sb.append(root.val + "->");
        }
        StringBuilder temp = new StringBuilder(sb);
        Paths(root.left, sb);
        Paths(root.right, temp);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Paths(root, sb);
        return list;
    }
}