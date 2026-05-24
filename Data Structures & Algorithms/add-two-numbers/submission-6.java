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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carryover = 0;
        ListNode l1pointer = l1;
        ListNode l2pointer = l2;
        
        ListNode head = new ListNode(-1);
        ListNode curr = head;

        while(l1pointer != null || l2pointer != null){
            int l1v = 0;
            int l2v = 0;
            if (l1pointer != null){
                l1v = l1pointer.val;
            }
            if (l2pointer != null){
                l2v = l2pointer.val;
            }
            
            
            int sum = l1v + l2v + carryover;
            if (sum > 9){
                carryover = 1;
                sum -= 10;
            }
            else{
                carryover = 0;
                sum = sum;
            }
            curr.val = sum;
            curr.next = new ListNode(-1);
            if(l1pointer != null){
                l1pointer = l1pointer.next;
            }
            if(l2pointer != null){
                l2pointer = l2pointer.next;
            }
            
            curr = curr.next;


        }
        if(l1pointer == null){
                if(carryover != 0){
                    curr.val = carryover;
                    return(head);
                }
                
        }

        if(curr.val == -1){
            ListNode current = head;
            while(current.next != null && current.next.next != null){
                current = current.next;
            }
            current.next = null;
            }
        

        return(head);


        
    }
}
