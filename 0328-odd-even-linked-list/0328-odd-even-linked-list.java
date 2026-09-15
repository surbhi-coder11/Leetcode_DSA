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
    public ListNode oddEvenList(ListNode head) {
        // Base case: empty list or single node
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even; // Even list ke start ko save karke rakho

        while (even != null && even.next != null) {
            // Odd links rewire karo
            odd.next = even.next;
            odd = odd.next;

            // Even links rewire karo
            even.next = odd.next;
            even = even.next;
        }

        // Odd chain ke end ko even chain ke head se connect karo
        odd.next = evenHead;

        return head;
    }
}