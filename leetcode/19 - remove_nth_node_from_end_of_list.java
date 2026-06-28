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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode current = dummy;

        int length = 0;
        while (current.next != null) {
            length++;
            current = current.next;
        }

        current = dummy;
        for (int i = 0; i < length - n; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        return dummy.next;
    }
}
