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
class BSTIterator {

    ListNode dummy = new ListNode(-1);
    ListNode head;

    public BSTIterator(TreeNode root) {
        head = dummy;
        performInorderTraversal(root);
        head = dummy.next;
    }

    public int next() {
        int val = head.val;
        head = head.next;
        return val;
    }

    public boolean hasNext() {
        return head != null;
    }

    private void performInorderTraversal(TreeNode root) {
        if (root == null) return;
        if (root.left != null) performInorderTraversal(root.left);
        // add val in linkedList
        head.next = new ListNode(root.val);
        head = head.next;
        if (root.right != null) performInorderTraversal(root.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */