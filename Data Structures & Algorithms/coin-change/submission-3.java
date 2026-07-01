class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for(int x = 0; x < dp.length; x++){
            dp[x] = amount + 5;
        }


        for(int i = 0; i <= amount; i++){
            if( i == 0){
                dp[i] = 0; 
            }
            else{
                for(int c: coins){
                    if(c <= i){
                        dp[i] = Math.min(dp[i], dp[i -c] + 1);
                    }
                    
                } 
                
            }


        }
        if (dp[amount] == amount + 5){
            return(-1);
        }
        return(dp[amount]);
    }
}
