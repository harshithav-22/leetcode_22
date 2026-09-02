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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int[] inorder,
                          int preIndex, int inStart, int inEnd) {

        if (inStart > inEnd) {
            return null;
        }

        // First element in preorder is root
        int rootValue = preorder[preIndex];
        TreeNode root = new TreeNode(rootValue);

        // Find root in inorder
        int index = inStart;

        while (inorder[index] != rootValue) {
            index++;
        }

        // Build left subtree
        root.left = build(preorder, inorder,
                          preIndex + 1,
                          inStart,
                          index - 1);

        // Build right subtree
        root.right = build(preorder, inorder,
                           preIndex + (index - inStart) + 1,
                           index + 1,
                           inEnd);

        return root;
    }
}