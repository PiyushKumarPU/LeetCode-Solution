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
    int count;
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        count = 0;
        countNodesWorker(root);
        return count;
    }

    private void countNodesWorker(TreeNode treeNode) {
        if (treeNode == null) return;
        boolean hasLeftNode = treeNode.left != null;
        boolean hasRightNode = treeNode.right != null;
        if ((hasRightNode && hasLeftNode)) count++;
        else if (hasLeftNode) count++;
        else if (!hasRightNode) count++;
        if (hasLeftNode) countNodesWorker(treeNode.left);
        if (hasRightNode) countNodesWorker(treeNode.right);
    }

}