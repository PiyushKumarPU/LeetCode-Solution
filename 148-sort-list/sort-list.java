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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode middle = splitList(head);
        ListNode left = sortList(head);
        ListNode right = sortList(middle);

        return merge(left, right);

    }

    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while (list1 != null || list2 != null) {
            int first = list1 == null ? Integer.MAX_VALUE : list1.val;
            int second = list2 == null ? Integer.MAX_VALUE : list2.val;
            if (first < second) {
                current.next = new ListNode(first);
                current = current.next;
                list1 = list1.next;
            } else if (second < first) {
                current.next = new ListNode(second);
                current = current.next;
                list2 = list2.next;
            } else if (first != Integer.MAX_VALUE) {
                current.next = new ListNode(first);
                current = current.next;
                list1 = list1.next;
                current.next = new ListNode(second);
                current = current.next;
                list2 = list2.next;
            }
        }
        return dummy.next;
    }

    private ListNode splitList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode middle = slow.next;
        slow.next = null;
        return middle;
    }

}