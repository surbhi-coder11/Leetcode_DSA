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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        // 1. Sentinel dummy node covers left = 1
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 2. Walk 'prev' to the node immediately before 'left' (index left - 1)
        ListNode prev = dummy;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // 'curr' points to the start of the sublist to reverse
        ListNode curr = prev.next;

        // 3. Perform (right - left) pointer rewires
        for (int i = 0; i < right - left; i++) {
            ListNode forw = curr.next;       // Node to pull to the front
            curr.next = forw.next;           // Bypass 'forw'
            forw.next = prev.next;           // Point 'forw' to current sublist head
            prev.next = forw;                // Splice 'forw' right after 'prev'
        }

        return dummy.next;
    }
}