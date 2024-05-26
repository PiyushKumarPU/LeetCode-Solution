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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        int length = getLength(head);
        if (k >= length)
            k = k % length;
        if(k == 0) return head;
        head = reverse(head);
        ListNode temp = head;
        int count = k - 1;
        while (temp != null && count > 0) {
            temp = temp.next;
            count--;
        }
        // break the link
        ListNode firstPart = head;
        ListNode secondPart = temp.next;
        temp.next = null;
        firstPart = reverse(firstPart);
        secondPart = reverse(secondPart);
        temp = firstPart;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = secondPart;
        return firstPart;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode current = head;
        ListNode next, prev = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    private int getLength(ListNode head){
        ListNode temp = head;
        int count = 0;
        while (temp != null){
            temp = temp.next;
            count++;
        }
        System.out.println(count);
        return count;
    }
}