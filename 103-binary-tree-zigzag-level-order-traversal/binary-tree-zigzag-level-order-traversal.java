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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        // perform normal inorder traversal and for all odd level add element from last
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        int level = 0;
        while (!nodeQueue.isEmpty()) {
            int queueSize = nodeQueue.size();
            ArrayList<Integer> row = new ArrayList<>();
            for (int i = 0; i < queueSize; i++) {
                TreeNode current = nodeQueue.poll();
                row.add(current.val);
                if (current.left != null) nodeQueue.add(current.left);
                if (current.right != null) nodeQueue.add(current.right);
            }
            if (level % 2 == 0) result.add(row);
            else {
                Collections.reverse(row);
                result.add(row);
            }
            level++;
        }
        return result;
    }
}