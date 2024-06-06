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
    int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        diameter = 0;
        calculateDiameter(root);
        return diameter;
    }

    private int calculateDiameter(TreeNode treeNode) {
        if (treeNode == null) return -1;
        int leftHeight = (treeNode.left != null) ? calculateDiameter(treeNode.left) : -1;
        int rightHeight = (treeNode.right != null) ? calculateDiameter(treeNode.right) : -1;
        int currentNodeHeight = Math.max(leftHeight, rightHeight) + 1;
        diameter = Math.max((leftHeight + rightHeight + 2), diameter);
        return currentNodeHeight;
    }
}