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
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        result = new ArrayList<>();
        inorderTraversalWorker(root);
        int minDifference = Integer.MAX_VALUE;
        for (int i = 1; i < result.size(); i++)
            minDifference = Math.min(minDifference, result.get(i) - result.get(i - 1));
        return minDifference;
    }

    private void inorderTraversalWorker(TreeNode treeNode) {
        if (treeNode == null) return;
        inorderTraversalWorker(treeNode.left);
        result.add(treeNode.val);
        inorderTraversalWorker(treeNode.right);
    }
}