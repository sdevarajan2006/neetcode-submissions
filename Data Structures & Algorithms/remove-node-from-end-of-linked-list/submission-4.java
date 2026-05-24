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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // go through once to find the length
        int len = 0;
        ListNode curr = head;
        if (curr == null){
            return null;
        }

        while(curr.next != null){
            len += 1;
            curr = curr.next;
        }
        len += 1;
        

        int indexToRemove = len - n; 
        curr = head;
        if(indexToRemove == 0){
            return head.next;
        }
        if(n == 1){
            while(curr.next.next != null){
                curr = curr.next;
            }
            curr.next = null;
            return (head);
        }


        curr = head;
        
        int i = 1; 
        while(i != indexToRemove){
            i += 1;
            curr = curr.next;
        }

        // now we are at the node previous to what needs to be removed
        ListNode nextNext = curr.next.next; 
        curr.next = nextNext;

        return(head);


    }
}
