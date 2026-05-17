class Solution {
    public int longestConsecutive(int[] nums) {

        // edges
        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return 1;
        }

        // find the largest element in nums 
        int largestNumber = Integer.MIN_VALUE;

        // find the smallest elemnt in nums
        int smallestNumber = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(num > largestNumber){
                largestNumber = num;
            }
            if(num < smallestNumber){
                smallestNumber = num;
            }
        }

        // use this to build out arrays
        int[] positives = new int[largestNumber + 1];
        int[] negatives;
        if (smallestNumber < 0){
            negatives = new int[smallestNumber * -1];
        }
        else{
            negatives = new int[0];
        }
        
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(num >= 0){
                positives[num] = 1;
            }
            else {
                negatives[(smallestNumber * -1) - (-1 * num)] = 1;
            }
                
        }

        int[] combinedList = new int[positives.length + negatives.length];
        int currentIndex = 0;
        for(int i = 0; i < negatives.length; i++){
            combinedList[currentIndex] = negatives[i];
            currentIndex += 1;
        }

        for(int i = 0; i < positives.length; i++){
            combinedList[currentIndex] = positives[i];
            currentIndex += 1;
        }

        // now go through combined list 
        int maxSeq = 0; 
        int currSeq = 0;

        for(int i = 0; i < combinedList.length; i++){
            int num = combinedList[i];
            if (num == 1){
                currSeq += 1;
            }
            else{
                if (currSeq > maxSeq){
                    maxSeq = currSeq;
                }
                currSeq = 0;
            }
        }

        if (currSeq > maxSeq){
            maxSeq = currSeq;
        }

        return maxSeq;
        

        
    }
}
