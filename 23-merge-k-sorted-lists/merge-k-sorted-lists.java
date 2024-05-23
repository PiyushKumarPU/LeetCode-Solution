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
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        for(ListNode node : lists){
            if(node == null) continue;
            minHeap.add(node);
        } 
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(!minHeap.isEmpty()){
            ListNode current = minHeap.poll();
            temp.next = new ListNode(current.val);
            temp = temp.next;
            if(current.next != null)
                minHeap.offer(current.next);
        }
        return dummy.next;
    }
}