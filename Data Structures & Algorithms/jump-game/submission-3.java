class Solution {
    public boolean canJump(int[] nums) {
        // work backwards 
        boolean[] cans = new boolean[nums.length]; 
        cans[nums.length - 1] = true; 
        for(int i = nums.length - 2; i >= 0; i--){
            int jumpLength = nums[i]; 
            for(int j = 1; j <= jumpLength; j++){
                if(i + j < nums.length && cans[i + j] == true){
                    cans[i] = true; 
                }
            }
        }

        for(boolean b: cans){
            System.out.println(b); 
        }
        return cans[0]; 


        
    }

   
}
