/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode current = null;
        while (head != null) {
            if (current == null)
                current = new ListNode(head.val);
            else {
                ListNode newNode = new ListNode(head.val);
                newNode.next = current;
                current = newNode;
            }
            head = head.next;
        }
        return current;
        
    }
}