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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;
        ListNode curr = mid.next;
        mid.next = null;
        ListNode prev = null;
        ListNode next;

        while(curr!=null){
            next= curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode A = head;
        ListNode B = prev;

        while(head!=null && prev != null){
            if(head.val != prev.val){
                return false;
            }
            head = head.next;
            prev = prev.next;
        }

      return true;

    }
}