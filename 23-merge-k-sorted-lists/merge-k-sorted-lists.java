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
        ListNode temp = new ListNode(0);
        ListNode head = temp;
        Integer nextMin = findNextMin(lists);
        while (nextMin != null) {
            head.next = new ListNode(nextMin);
            head = head.next;
            nextMin = findNextMin(lists);
        }
        return temp.next;
    }

    private Integer findNextMin(ListNode[] lists) {
         Integer currentMin = Integer.MAX_VALUE, minIndex = -1;
        for (int i = 0; i < lists.length; i++) {
            ListNode current = lists[i];
            if (current == null)
                continue;
            if (lists[i].val < currentMin) {
                currentMin = lists[i].val;
                minIndex = i;
            }
        }
        if (minIndex >= 0 && lists[minIndex] != null) {
            lists[minIndex] = lists[minIndex].next;
            return currentMin;
        }
        return null;

    }
}