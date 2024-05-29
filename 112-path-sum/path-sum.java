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
    boolean hasPathSum = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        isPathSumPresent(root,targetSum);
        return hasPathSum;
    }

    private void isPathSumPresent(TreeNode root, int target) {
        if (root == null || hasPathSum) return;
        boolean isLeafNode = root.left == null && root.right == null;
        if (isLeafNode && target - root.val == 0) hasPathSum = true;
        if (!hasPathSum) {
            if (root.left != null)
                isPathSumPresent(root.left, target - root.val);
            if (root.right != null)
                isPathSumPresent(root.right, target - root.val);
        }
    }
}