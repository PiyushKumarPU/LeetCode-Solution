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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        Map<String, List<TreeNode>> lookup = new HashMap<>();
        serialize(root, lookup);

        for (List<TreeNode> nodes : lookup.values()) {
            if (nodes.size() > 1) {
                result.add(nodes.get(0));
            }
        }

        return result;
    }

    private String serialize(TreeNode node, Map<String, List<TreeNode>> lookup) {
        if (node == null) {
            return "#";
        }

        String serial = node.val + "," + serialize(node.left, lookup) + "," + serialize(node.right, lookup);
        lookup.computeIfAbsent(serial, k -> new ArrayList<>()).add(node);
        return serial;
    }
}