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
        ListNode pA = headA;
        ListNode pB = headB;
        while(pA!=pB)
        {
            if(pA==null)
            {
                pA = headB;
            }
            else
            {
                pA=pA.next;
            }
            if(pB==null)
            {
                pB=headA;
            }
            else
            {
                pB=pB.next;
            }

        }
        return pA;
        // Set<ListNode> set = new HashSet<ListNode>();
        // while(headB!=null)
        // {
        //     set.add(headB);
        //     headB = headB.next;
        // }
        // while(headA!=null)
        // {
        //     if(set.contains(headA))
        //     {
        //         return headA;
        //     }
        //     headA=headA.next;
        // }
        // return null;
    }

}