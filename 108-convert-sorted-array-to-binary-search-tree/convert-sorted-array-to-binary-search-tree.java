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
    public TreeNode sortedArrayToBST(int[] nums) {
        return constructNode(nums, 0, nums.length - 1);
    }

    private TreeNode constructNode(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = (end + start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = constructNode(nums, start, mid - 1);
        root.right = constructNode(nums, mid + 1, end);
        return root;
    }
}