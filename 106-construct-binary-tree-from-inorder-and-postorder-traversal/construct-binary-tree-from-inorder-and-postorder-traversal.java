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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) return null;
        Map<Integer, Integer> valIndexMap = new HashMap<>();
        int index = 0;
        for (int i : inorder) valIndexMap.put(i, index++);
        return buildTree(postorder, valIndexMap, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] postOrder, Map<Integer, Integer> valIndexMap, int inStart, int inEnd,
                               int poStart, int poEnd) {
        if (inStart > inEnd) return null;

        int rootVal = postOrder[poEnd];
        int rootIndex = valIndexMap.get(rootVal);
        int eleCount = rootIndex - inStart;

        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(postOrder, valIndexMap, inStart, inStart + eleCount - 1, poStart, poStart + eleCount - 1);
        root.right = buildTree(postOrder, valIndexMap, rootIndex + 1, inEnd, poStart + eleCount, poEnd - 1);
        return root;
    }
}