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

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Double sum = 0.0;
        int size = 0;
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            while (queue.peek() != null) {
                TreeNode curr = queue.remove();
                sum += curr.val;
                size++;
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            if (queue.remove() == null) {
                ans.add(sum / size);
                sum = 0.0;
                size = 0;
                if (queue.isEmpty()) {
                    break;
                } else {
                    queue.add(null);
                }
            }
        }
        return ans;
    }
}