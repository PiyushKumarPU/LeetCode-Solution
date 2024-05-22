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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while(list1 != null || list2 != null){
            int val1 = list1 != null ? list1.val : Integer.MAX_VALUE;
            int val2 = list2 != null ? list2.val : Integer.MAX_VALUE;
            if(val1 > val2){
                current.next = new ListNode(val2);
                current = current.next;
                list2 = list2 != null ? list2.next : list2;
            }else if(val1 < val2){
                current.next = new ListNode(val1);
                current = current.next;
                list1 = list1 != null ? list1.next : list1;
            }else{
                if(val1 != Integer.MAX_VALUE){
                    current.next = new ListNode(val2);
                    current = current.next;
                    current.next = new ListNode(val1);
                    current = current.next;
                    list1 = list1 != null ? list1.next : list1;
                    list2 = list2 != null ? list2.next : list2;
                }
            }
        }
        return dummy.next;
    }
}