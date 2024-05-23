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
    public List<List<Integer>> zigzagLevelOrder(TreeNode A) {
        List<List<Integer>> zigzag = new ArrayList<>();
        if(A == null) return zigzag;
        Stack<TreeNode> stack1 = new Stack<>(), stack2 = new Stack<>();
        if (A == null)
            return null;

        stack1.push(A);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();
            while (!stack1.isEmpty()) {
                TreeNode node = stack1.pop();
                level.add(node.val);
                if (node.left != null)
                    stack2.push(node.left);
                if (node.right != null)
                    stack2.push(node.right);
            }
            if (!level.isEmpty())
                zigzag.add(level);
            level = new ArrayList<>();

            while (!stack2.isEmpty()) {
                TreeNode node = stack2.pop();
                level.add(node.val);
                if (node.right != null)
                    stack1.push(node.right);
                if (node.left != null)
                    stack1.push(node.left);
            }
            if (level.size() != 0)
                zigzag.add(level);
        }
        return zigzag;
    }
}