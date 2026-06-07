class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // put them in a minheap
        java.util.PriorityQueue<int[]> minHeap = new java.util.PriorityQueue<>(
            (a,b) -> Integer.compare(distance(a), distance(b)));
        
        for(int[] p : points){
            minHeap.add(p);
        }
        int[][] ans = new int[k][2];
        int counter = k; 
        while(counter != 0){
            int[] smally = minHeap.poll();
            ans[counter - 1] = smally; 
            counter -= 1;

        }
        return(ans);

        

    }

    public int distance(int[] point){
        int x = point[0]; 
        int y = point[1];
        return((x*x) + (y*y)); 
        
    }
}
