class LRUCache {
    class Node{
        int key; 
        int value; 
        Node prev;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value; 
        }

        public void setNext(Node next){
            this.next = next;
        }

        public void setPrev(Node prev){
            this.prev = prev;
        }
    }
    
    int size = 0;
    Node head;
    Node tail;
    int capacity;
    java.util.HashMap<Integer, Node> stor;

    private void remove(Node node){
        Node p = node.prev;
        Node n = node.next;
        node.setNext(null);
        node.setPrev(null);
        p.setNext(n);
        n.setPrev(p);
        size -= 1;
    }

    private void insertBeforeTail(Node node){
        Node op = tail.prev;
        op.setNext(node);
        node.setPrev(op);
        node.setNext(tail);
        tail.setPrev(node);
        size += 1;
    }

    private void removeBeforeFront(){
        Node nextNext = head.next.next;
        head.setNext(nextNext);
        nextNext.setPrev(head);
        size -= 1;
    }
    


    public LRUCache(int capacity) {
        Node newNode = new Node(-1,-1);
        Node anotherNewNode = new Node(-1,-1);
        newNode.setNext(anotherNewNode);
        anotherNewNode.setPrev(newNode);
        head = newNode;
        tail = anotherNewNode;
        this.capacity = capacity;
        this.stor = new java.util.HashMap<>();
        
    }
    
    public int get(int key) {
        if (stor.containsKey(key)){
            Node corr = stor.get(key);
            remove(corr);
            insertBeforeTail(corr);

            return(corr.value);

        }
        return(-1);  
    }
    
    public void put(int key, int value) {
        if(stor.containsKey(key)){
            Node toChange = stor.get(key);
            toChange.value = value;
            remove(toChange);
            insertBeforeTail(toChange);
            return;
        }
        
        Node newNode = new Node(key, value);
        stor.put(key, newNode);

        if(size == capacity){
            Node toRemove = head.next;
            int toRemoveKey = toRemove.key;
            stor.remove(toRemoveKey);
            removeBeforeFront(); 
        }
        insertBeforeTail(newNode);
    }
}
