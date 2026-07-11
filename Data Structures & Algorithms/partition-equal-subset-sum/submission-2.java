class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0; 
        for(int num: nums){
            total += num;
        }
        if(total % 2 == 1){
            return false;
        }
        total /= 2;
        boolean[] dp = new boolean[total +1];

        dp[0] = true; 
        for(int num: nums){
            for(int i = dp.length -1; i >= 0; i--){
                if(i - num >= 0 ){
                    dp[i] = (dp[i] || dp[i - num]);
                }
                
            }
        }
        return(dp[total]);
        
    }

    
}
