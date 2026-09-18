/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int exists = -1;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow == fast){
                exists = 0;
                break;
            }
        }
        if(exists == -1){
            return null;
        }

        slow = head;
        while(slow!=fast){
            slow  = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}