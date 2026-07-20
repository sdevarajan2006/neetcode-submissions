class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = 0;
        int globalMaxSum = Integer.MIN_VALUE;


        for(int num : nums){
            currentSum = Math.max(num, currentSum + num); 
            globalMaxSum = Math.max(globalMaxSum, currentSum); 
            System.out.println(currentSum);
            System.out.println(globalMaxSum);
        }
        

        return(globalMaxSum);

    }

}
