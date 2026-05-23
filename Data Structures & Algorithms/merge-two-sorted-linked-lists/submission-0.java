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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode list1curr = list1;
        ListNode list2curr = list2;

        ListNode head = new ListNode(-1);
        ListNode curr = head;

        while(list1curr != null && list2curr != null){
            int list1val = list1curr.val;
            int list2val = list2curr.val;
            if (list1val < list2val){
                ListNode list1next = list1curr.next;
                list1curr.next = null;
                curr.next = list1curr;
                curr = list1curr;
                list1curr = list1next;

            }
            else{
                ListNode list2next = list2curr.next;
                curr.next = list2curr;
                curr = list2curr;
                curr.next = null; 
                list2curr = list2next;
            }
        }
        if (list1curr == null){
            curr.next = list2curr;
        }
        else{
            curr.next = list1curr;
        }
        return(head.next);
        
    }
}