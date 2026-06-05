class KthLargest {
    // key idea - keep only the k largest numbers seen so far. smallest among those is the kth largest overall 
    // use a minheap
    int k;
    java.util.PriorityQueue<Integer> minHeap = new PriorityQueue<>();


    public KthLargest(int k, int[] nums) {
    
    this.k = k;
    for(int num: nums){
        add(num);
    }
    
    }
    
    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > k){
            minHeap.poll();

        }

        return(minHeap.peek());

        
    }
}
