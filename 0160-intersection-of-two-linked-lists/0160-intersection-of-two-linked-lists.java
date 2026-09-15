public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        // 1. Dono lists ki length count karo
        int lenA = getLength(headA);
        int lenB = getLength(headB);

        ListNode pA = headA;
        ListNode pB = headB;

        // 2. Jo list lambi hai uske pointer ko difference jitna aage badhao
        int diff = Math.abs(lenA - lenB);
        if (lenA > lenB) {
            while (diff-- > 0) {
                pA = pA.next;
            }
        } else {
            while (diff-- > 0) {
                pB = pB.next;
            }
        }

        // 3. Dono ko sath me chalao jab tak collision na ho
        while (pA != null && pB != null) {
            if (pA == pB) {
                return pA; // Intersection mil gaya
            }
            pA = pA.next;
            pB = pB.next;
        }

        return null; // Koi intersection nahi hai
    }

    private int getLength(ListNode head) {
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        return length;
    }
}