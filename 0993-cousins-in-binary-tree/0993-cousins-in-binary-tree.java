/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            boolean Xcheck = false, Ycheck = false;
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node.left != null && node.right != null) {
                    int left = node.left.val;
                    int right = node.right.val;
                    if ((left == x && right == y) || (right == x && left == y)) {
                        return false;
                    }
                }
                if (node.val == x) {
                    Xcheck = true;
                }
                if (node.val == y) {
                    Ycheck = true;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            if(Xcheck && Ycheck){
                return true;
            }

            if(Xcheck || Ycheck){
                return false;
            }
        }
        return false;
    }
}