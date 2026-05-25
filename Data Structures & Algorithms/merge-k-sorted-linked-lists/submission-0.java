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
        if(lists.length == 0){
            return null;
        }
        if (lists.length == 1){
            return(lists[0]);
        }

        int i = 1; 
        while (i < lists.length){
            ListNode l1 = lists[i - 1];
            ListNode l2 = lists[i];
            ListNode resulting = mergeTwoLists(l1,l2);
            lists[i] = resulting;
            i += 1;

        }

        return lists[i - 1];

        

    }

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
