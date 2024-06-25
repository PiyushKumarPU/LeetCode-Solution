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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode base = new ListNode(head.val);
        ListNode current = base, temp = head.next;
        while (temp != null) {
            if (temp.val != current.val) {
                current.next = new ListNode(temp.val);
                current = current.next;
            }
            temp = temp.next;
        }
        return base;
    }
}