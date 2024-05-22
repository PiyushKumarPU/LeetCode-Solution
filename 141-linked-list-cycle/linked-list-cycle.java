/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // using constant space
        if(head == null || head.next == null) return false;
        ListNode slow = head, fast = head;
        Boolean hasCycle = false;
        while(fast != null && fast.next != null){
            // jumping slow pointer by 1 and fast by 2
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                hasCycle = true;
                break;
            }
        }
        return hasCycle;
    }
}