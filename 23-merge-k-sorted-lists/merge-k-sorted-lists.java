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
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode node : lists) {
            if (node != null)
                minHeap.add(node);
        }
        ListNode temp = new ListNode(0);
        ListNode head = temp;
        while (!minHeap.isEmpty()) {
            ListNode smallest = minHeap.poll();
            head.next = new ListNode(smallest.val);
            head = head.next;
            if (smallest.next != null)
                minHeap.add(smallest.next);
        }
        return temp.next;
    }

}