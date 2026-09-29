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
        if (head == null || k == 1) return head;
        
        // Dummy node to simplify edge cases when the head itself changes
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode curr = dummy, prev = dummy, nxt = dummy;
        
        // Step 1: Count the total number of nodes in the linked list
        int count = 0;
        while (curr.next != null) {
            curr = curr.next;
            count++;
        }
        
        // Step 2: Reverse nodes in groups of k as long as enough nodes remain
        while (count >= k) {
            curr = prev.next;
            nxt = curr.next;
            
            // Reverse k nodes by repositioning pointers
            for (int i = 1; i < k; i++) {
                curr.next = nxt.next;
                nxt.next = prev.next;
                prev.next = nxt;
                nxt = curr.next;
            }
            
            // Move `prev` pointer to the end of the newly reversed group
            prev = curr;
            count -= k;
        }
        
        return dummy.next;
    }
}