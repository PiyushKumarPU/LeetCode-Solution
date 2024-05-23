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
    public boolean isValidBST(TreeNode root) {
        return root == null ? true : isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode A, Long start, Long end) {
        if (A == null) return true;
        if (start <= A.val && A.val <= end) {
            return isValidBST(A.left, start, (long)A.val - 1) 
                && isValidBST(A.right, (long)A.val + 1, end);
        }
        return false;
    }
}