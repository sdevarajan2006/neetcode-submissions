class Solution {
    public int findKthLargest(int[] nums, int k) {
        java.util.PriorityQueue<Integer> maxHeap = new java.util.PriorityQueue<>(Collections.reverseOrder()); 
        for(int num : nums){
            maxHeap.add(num); 
        }

        int counter = 1; 
        while(counter != k){
            maxHeap.poll();
            counter += 1;
        }
        int ans = maxHeap.poll();
        return(ans); 
        
    }
}
