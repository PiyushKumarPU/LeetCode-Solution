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
        if (head == null) return head;
        ListNode current = new ListNode(head.val);
        head = head.next;
        while (head != null) {
            ListNode newNode = new ListNode(head.val);
            newNode.next = current;
            current = newNode;
            head = head.next;
        }
        return current;
        
    }
}