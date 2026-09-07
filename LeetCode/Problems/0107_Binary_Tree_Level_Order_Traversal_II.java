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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> outList = new ArrayList<>();
        if (root == null) {
            return outList;
        }
        Stack<List<Integer>> s1 = new Stack<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            TreeNode currNode = q.remove();
            List<Integer> l1 = new ArrayList<>();
            while (currNode != null) {
                l1.add(currNode.val);
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
                currNode = q.remove();
            }
            if (currNode == null) {
                if (!q.isEmpty()) {
                    q.add(null);
                }
                s1.push(l1);
            }
        }
        while (!s1.isEmpty()) {
            outList.add(s1.pop());
        }
        return outList;
    }
}