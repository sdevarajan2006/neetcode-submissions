class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] ans = new int[cost.length];
        for(int i = cost.length -1; i >= 0; i --){
            if (i == cost.length -1){
                ans[i] = cost[i]; 
            }
            else if(i == cost.length - 2){
                ans[i] = cost[i]; 
            }
            else{
                ans[i] = cost[i] + Math.min(ans[i+1], ans[i + 2]);            
            }
            
        }
        
        return(Math.min(ans[0], ans[1]));
        
    }
}
