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
    int maxPath;
    public int maxPathSum(TreeNode root) {
        maxPath = Integer.MIN_VALUE;
        calculatePathSum(root);
        return maxPath;
    }

    private int calculatePathSum(TreeNode root) {
        if (root == null) return 0;
        int left = root.left == null ? 0 : calculatePathSum(root.left);
        int right = root.right == null ? 0 : calculatePathSum(root.right);
        int currentMax = root.val;
        currentMax = Math.max(currentMax, root.val + left);
        currentMax = Math.max(currentMax, root.val + right);
        currentMax = Math.max(currentMax, root.val + left + right);
        maxPath = Math.max(maxPath, currentMax);
        return Math.max(root.val,Math.max(root.val + left, root.val + right));
    }
}