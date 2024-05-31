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
    public ListNode reverseKGroup(ListNode A, int B) {
        if (A == null || A.next == null || B < 1) return A;
        int size = 0;
        ListNode temp = A;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        int iterationCount = size / B; // + (size % B > 0 ? 1 : 0);
        A = reverseListWithNodeCount(A, B);
        ListNode prevEnd = A;
        for (int index = 1; index < iterationCount; index++) {
            int jumpCount = B - 1;
            while (jumpCount > 0 && prevEnd != null) {
                prevEnd = prevEnd.next;
                jumpCount--;
            }
            if (prevEnd != null) {
                prevEnd.next = reverseListWithNodeCount(prevEnd.next, B);
                prevEnd = prevEnd.next;
            }
        }
        return A;
    }

    private ListNode reverseListWithNodeCount(ListNode A, int count) {
        if (A == null)
            return null;
        ListNode node = A, prev = null, temp;
        while (node != null && count > 0) {
            temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
            count--;
        }
        A.next = node;
        return prev;
    }
}