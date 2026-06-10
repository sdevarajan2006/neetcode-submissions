class MedianFinder {
    // we maintian 2 heaps of equal size
    // the first one is leftHeap, a maxheap with numbers <= median
    // second is rightHeap, a minHeap with number > median 

    // we always maintain that leftHeap.size >= 1 + rightHeap.size
    // if leftHeap gets too big, then we pop the top off and send it to rightHeap
    // and vice versa

    java.util.PriorityQueue<Integer> leftHeap; 
    java.util.PriorityQueue<Integer> rightHeap;

    public MedianFinder() {
        leftHeap = new java.util.PriorityQueue<>(Collections.reverseOrder()); 
        rightHeap = new java.util.PriorityQueue<>();         
        leftHeap.add(Integer.MIN_VALUE); 
        rightHeap.add(Integer.MAX_VALUE); 
    }
    
    public void addNum(int num) {
        int leftTop = leftHeap.peek(); 
        int rightTop = rightHeap.peek(); 
        if(num >= rightTop){
            rightHeap.add(num); 
        }
        else{
            leftHeap.add(num);
        }

        if(leftHeap.size() > rightHeap.size() + 1){
            int val = leftHeap.poll(); 
            rightHeap.add(val);
        }

        if(rightHeap.size() > leftHeap.size() + 1){
            int val = rightHeap.poll();
            leftHeap.add(val);
        }


        
    }
    
    public double findMedian() {
        int leftSize = leftHeap.size(); 
        int rightSize = rightHeap.size();
        int leftVal = leftHeap.peek();
        int rightVal = rightHeap.peek();
        if(leftSize == rightSize){
            return(((double) leftVal + rightVal) / 2);
            
        }
        else if(leftSize > rightSize){
            return(leftVal);
        }
        return(rightVal);
    }
}
