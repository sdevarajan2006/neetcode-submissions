class Solution {
    public boolean canJump(int[] nums) {
        int targetIndex = nums.length - 1; 

        boolean[] cans = new boolean[nums.length]; 
        cans[nums.length - 1] = true; 

        for(int i = targetIndex -1; i >= 0; i--){
            canJump(nums,cans,i);
        }

        return(cans[0]); 


        
    }

    public void canJump(int[] nums, boolean[] cans, int currIndex){
        int maxJumpLength = nums[currIndex]; 
        for(int i = 1; i <= maxJumpLength; i++){
            if(cans[currIndex + i]){
                cans[currIndex] = true;
                return;
            }
        }

        return; 


    }
}
