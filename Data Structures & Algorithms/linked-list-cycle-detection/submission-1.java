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
    public boolean hasCycle(ListNode head) {
        ListNode curr = head;
        if (curr == null){
            return false;
        }

        while(curr.next != null){
            curr.val = 1001;
            ListNode next = curr.next;
            int nextVal = next.val;
            if (nextVal == 1001){
                return true;
            }
            curr = curr.next;
        }
        return false;
    }
}
