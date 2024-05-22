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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || (head.next == null && n == 1)) return null;
        // find length of the LinkedList
        int nodeCount = 0;
        ListNode temp = head;
        while (temp != null) {
            nodeCount++;
            temp = temp.next;
        }
        int jumpCount = nodeCount - 1 - n;
        temp = head;
        if (jumpCount < 0) {
            head = head.next;
        } else {
            for (int i = 0; i < jumpCount; i++)
                temp = temp.next;
            temp.next = temp.next.next;
        }
        return head;
    }
}