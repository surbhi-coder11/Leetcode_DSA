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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length ==0){
            return null;
        }
        return mergeinrange(lists,0,lists.length-1);
    }
    private ListNode mergeinrange(ListNode[] lists, int st ,  int en){
        if(st==en){
            return lists[st];
        }
        int mid = st + (en-st)/2;
        ListNode leftlist = mergeinrange(lists,st, mid);
        ListNode rightlist = mergeinrange(lists,mid+1,en);
        
        return mergenodes(leftlist,rightlist);
        
    }
    private ListNode mergenodes(ListNode head1 , ListNode head2){
        ListNode dummy = new ListNode(-1);
        ListNode curr =  dummy;

        while(head1!=null && head2!=null){
            if(head1.val>=head2.val){
                curr.next = head2;
                curr = curr.next;
                head2 = head2.next;
            }else{
                curr.next = head1;
                curr = curr.next;
                head1 = head1.next;
            }
        }
      while(head1!=null){
         curr.next = head1;
         curr = curr.next;
         head1 = head1.next;
      }
      while(head2!=null){
         curr.next = head2;
          curr = curr.next;
          head2 = head2.next;
      }

      return dummy.next;
        
    }
}