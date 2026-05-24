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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            if(slow.next == null){
                System.out.println("whatthehellyonte");
            }
            if(fast.next.next == null){
                System.out.println("whatthehellyberry");
            }

            slow = slow.next;
            fast = fast.next.next;
        }
    

        ListNode slownext = slow.next;
        slow.next = null;

        ListNode curr = slownext;
        ListNode prev = null;
        ListNode next = null;
        if(curr == null){
            return;
        }
        if (curr.next != null){
            next = curr.next;
        }
        
        

        while(curr.next != null){
            // reverse it 
            curr.next = prev;
            prev = curr;
            curr = next;
            next = curr.next;
        }
        curr.next = prev;

        // combine
        ListNode l1pointer = head;
        ListNode l2pointer = curr;
        

        

        
        



        
        while(l1pointer.next != null){
            ListNode l1pointerNext = l1pointer.next;
            ListNode l2pointerNext = l2pointer.next;
            l1pointer.next = l2pointer;
            l2pointer.next = l1pointerNext;
            l1pointer = l1pointerNext;
            l2pointer = l2pointerNext;

        }
        if (l2pointer != null){
            l1pointer.next = l2pointer;
        }
        


        
    }
}
