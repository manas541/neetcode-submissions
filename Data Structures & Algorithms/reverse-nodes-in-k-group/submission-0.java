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
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        while (true) {

            ListNode kth = prev;

            for (int i = 0; i < k; i++) {
                kth = kth.next;

                if (kth == null) {
                    return dummy.next;
                }
            }

            ListNode groupNext = kth.next;

            ListNode groupStart = prev.next;
            ListNode prevNode = groupNext;
            ListNode current = groupStart;

            while (current != groupNext) {
                ListNode temp = current.next;
                current.next = prevNode;
                prevNode = current;
                current = temp;
            }

            prev.next = kth;

            
            prev = groupStart;
        }
    }
}