/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node curr = head;
        int[][] list = new int[100][];
        int i = 0;
        java.util.HashMap<Node, Node> stores = new java.util.HashMap<>();

        while (curr != null){
            int currVal = curr.val;
            Node newNode = new Node(currVal);
            stores.put(curr, newNode);
            curr = curr.next;
        }

        curr = head;

        while(curr != null){
            Node currNext = curr.next;
            Node currRandom = curr.random;
            Node currCopy = stores.get(curr);
            currCopy.next = stores.get(currNext);
            currCopy.random = stores.get(currRandom);
            curr = curr.next;
        }

        curr = head;
        return(stores.get(curr));
        





        

    }
}
