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
       ArrayList<Integer> nodes = new ArrayList<>();
       ListNode head = new ListNode(0);
       ListNode pointer = head;
       for(ListNode l : lists )
       {    
            while(l!=null)
            {
                nodes.add(l.val);
                l = l.next;
            }
       }
       Collections.sort(nodes);
       System.out.println(nodes);
        for (int x : nodes) {
            pointer.next = new ListNode(x);
            pointer = pointer.next;
        }
       return head.next;
        
    }
}