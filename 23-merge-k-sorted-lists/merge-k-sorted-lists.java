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
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (ListNode node : lists) {
            while (node != null) {
                minHeap.add(node.val);
                node = node.next;
            }
        }

        ListNode temp = new ListNode(0);
        ListNode head = temp;
        while (!minHeap.isEmpty()) {
            head.next = new ListNode(minHeap.poll());
            head = head.next;
        }
        return temp.next;
    }

}