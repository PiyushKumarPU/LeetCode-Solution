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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeLists(lists, 0, lists.length - 1);
    }

    private static ListNode mergeLists(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        int mid = start + (end - start) / 2;
        ListNode left = mergeLists(lists, start, mid);
        ListNode right = mergeLists(lists, mid + 1, end);
        return mergeTwoLists(left, right);
    }

    private static ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        ListNode temp = new ListNode(0);
        ListNode head = temp;
        while (node1 != null || node2 != null) {
            // find currentMin
            int min = Math.min(node1 != null ? node1.val : Integer.MAX_VALUE,
                    node2 != null ? node2.val : Integer.MAX_VALUE);

            if (node1 != null && min == node1.val)
                node1 = node1.next;
            else node2 = node2.next;
            head.next = new ListNode(min);
            head = head.next;
        }
        return temp.next;
    }

}