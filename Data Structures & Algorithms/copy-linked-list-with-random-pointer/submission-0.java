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

        if (head == null) {
            return null;
        }

        // Step 1: Insert copied nodes after each original node
        Node current = head;

        while (current != null) {

            Node copy = new Node(current.val);

            copy.next = current.next;
            current.next = copy;

            current = copy.next;
        }

        // Step 2: Connect random pointers
        current = head;

        while (current != null) {

            if (current.random != null) {
                current.next.random = current.random.next;
            }

            current = current.next.next;
        }

        // Step 3: Separate original and copied lists
        current = head;
        Node copyHead = head.next;

        while (current != null) {

            Node copy = current.next;

            current.next = copy.next;

            if (copy.next != null) {
                copy.next = copy.next.next;
            }

            current = current.next;
        }

        return copyHead;
    }
}