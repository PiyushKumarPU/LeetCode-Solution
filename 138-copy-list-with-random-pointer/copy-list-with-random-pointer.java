/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Map<Node, Node> nodeMap = new HashMap<>();
        Node current = head;

        // First pass: create all nodes and populate the map
        while (current != null) {
            nodeMap.put(current, new Node(current.val));
            current = current.next;
        }

        current = head;

        // Second pass: assign next and random pointers
        while (current != null) {
            nodeMap.get(current).next = nodeMap.get(current.next);
            nodeMap.get(current).random = nodeMap.get(current.random);
            current = current.next;
        }

        return nodeMap.get(head);
    }
}