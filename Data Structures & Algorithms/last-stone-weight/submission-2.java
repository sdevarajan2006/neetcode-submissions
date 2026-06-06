class Solution {
    public int lastStoneWeight(int[] stones) {
        java.util.PriorityQueue<Integer> maxHeap = new java.util.PriorityQueue(Collections.reverseOrder());
        for (int stone: stones){
            maxHeap.add(stone);
        }
        while (maxHeap.size() > 1){
            int x = maxHeap.poll();
            int y = maxHeap.poll();
            if (x > y){
                maxHeap.add(x - y); 
            }
            System.out.println(x);
            System.out.println(y);
            System.out.println(maxHeap.size());

            
        }

        if (maxHeap.size() == 0){
            return 0; 
        }
        else{
            return maxHeap.poll();
        }
    }
}
