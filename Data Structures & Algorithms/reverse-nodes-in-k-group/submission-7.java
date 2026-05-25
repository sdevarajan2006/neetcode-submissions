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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1){
            return head;
        }
        ListNode wholeHead = null;
        ListNode prevTail = null;
        ListNode currHead = head;
        ListNode currTail = null;
        ListNode curr = head;

        int counter = 1;
        while (curr != null){
            curr = curr.next;
            if (curr == null){
                break;
            }
            counter += 1;
            if(counter == k){
                currTail = curr;
                if (curr != null){
                    curr = curr.next;
                }
                if (currTail != null){
                    currTail.next = null;

                }
                if(wholeHead == null){
                    wholeHead = reverseList(head);
                    prevTail = currHead;
                }
                else{
                    prevTail.next = reverseList(currHead);
                    prevTail = currHead;
                }
                counter = 1;
                currHead = curr;
                if (curr != null && curr.next == null){
                    prevTail.next = curr;
                    return(wholeHead);
                }

            }

        }

        System.out.println(counter);
        if (counter > 1){
            //System.out.println(prevTail.val);
            //System.out.println(currHead.val);

            prevTail.next = currHead;
        }
        return(wholeHead);
        
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null; 
        ListNode curr = head;

        if (head == null){
            return null;
        }
        
        if (head.next == null){
            return head;
        }
        
        ListNode next = head.next;

        while(curr.next != null){
            curr.next = prev; 
            prev = curr;
            curr = next;
            next = curr.next;
        }
        curr.next = prev; 
        return(curr);
    }

}
