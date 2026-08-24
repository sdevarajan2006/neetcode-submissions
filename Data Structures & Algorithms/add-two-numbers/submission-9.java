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
        ListNode ansHead = new ListNode(); 
        ListNode currAns = ansHead; 
        ListNode l1Pointer = l1; 
        ListNode l2Pointer = l2; 
        int carryOver = 0; 

        while (l1Pointer != null || l2Pointer != null ){
            int l1Val = 0; 
            int l2Val = 0; 

            if (l1Pointer != null ){
                l1Val = l1Pointer.val; 
            }

            if(l2Pointer != null){
                l2Val = l2Pointer.val; 
            }

            int sum = l1Val + l2Val + carryOver; 
            if(sum < 10){
                carryOver = 0; 
            }
            else{
                carryOver = 1; 
            }
            currAns.next = new ListNode(sum % 10); 
            currAns = currAns.next;
            if (l1Pointer != null ){
                l1Pointer = l1Pointer.next; 
            }
            if(l2Pointer != null){
                l2Pointer = l2Pointer.next; 
            }
            
            
        }

        if (carryOver == 1){
            currAns.next = new ListNode(1); 
        }

        return ansHead.next; 
        
        
    }
}
