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
    ArrayList<Integer> result;
    public void flatten(TreeNode root) {
        if (root == null) return;

        TreeNode current = root;
        while (current != null) {
            if (current.left != null) {
                // Find the rightmost node of the left subtree
                TreeNode rightmost = current.left;
                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }

                // Connect the right subtree of the current node to the rightmost node of the left subtree
                rightmost.right = current.right;

                // Move the left subtree to the right and set the left child to null
                current.right = current.left;
                current.left = null;
            }
            // Move on to the right subtree
            current = current.right;
        }
    }
}