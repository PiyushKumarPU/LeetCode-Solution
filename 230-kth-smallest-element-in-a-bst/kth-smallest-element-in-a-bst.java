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
    int count = 0, result = -1;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        result = -1;
        countElement(root);
        return result;
    }

    private void countElement(TreeNode root){
        if(root == null || result >= 0) return;
        countElement(root.left);
        count--;
        if(count == 0) result = root.val;
        if(count > 0) countElement(root.right);
    }


}