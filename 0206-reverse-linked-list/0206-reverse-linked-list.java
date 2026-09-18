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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
        return head;
    }
    
    ListNode newHead = reverseList(head.next); // Tail reverse ho gayi
    head.next.next = head;                     // Pichle node ko reverse chain ke peeche joda
    head.next = null;                          // Purana forward link cut kiya
    
    return newHead;
    }
}