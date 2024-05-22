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
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1),dummy2 = new ListNode(-1),
        current1 = dummy1, current2 = dummy2;
        while(head != null){
            if(head.val < x){
                current1.next = new ListNode(head.val);
                current1 = current1.next;
            }else{
                current2.next = new ListNode(head.val);
                current2 = current2.next;
            }
            head = head.next;
        }
        current1.next = dummy2.next;
        return dummy1.next;
        
    }
}