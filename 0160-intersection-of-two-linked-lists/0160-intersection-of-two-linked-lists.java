/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode listA = headA;
        ListNode listB = headB;

        int len1 = getLen(headA);
        int len2 = getLen(headB);
        int diff = Math.abs(len1 - len2);
        if(len1>len2){
            while(diff-- > 0){
                listA= listA.next;
            }
        }else{
            while(diff-->0){
                listB =listB.next;
            }
        }
        while(listA!=null && listB!=null){
            if(listA == listB){
                return listA;
            }
            listA = listA.next;
            listB = listB.next;
        }

        return null;

    }
    private int getLen(ListNode head){
        int len =0;
        ListNode temp = head;
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        return len;
    }
}