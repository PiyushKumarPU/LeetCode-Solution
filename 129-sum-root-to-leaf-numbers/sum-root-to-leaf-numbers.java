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
    int totalSum = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        sumNumbers(root, 0);
        return totalSum;
    }

    private void sumNumbers(TreeNode root, int currentVal) {
        if (root == null) return;
        currentVal = currentVal * 10 + root.val;
        if (root.left == null && root.right == null) totalSum += currentVal;
        else {
            if (root.left != null)
                sumNumbers(root.left, currentVal);
            if (root.right != null)
                sumNumbers(root.right, currentVal);
        }
    }
}