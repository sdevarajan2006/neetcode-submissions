class Solution {
    public int climbStairs(int n) {
        int[] solns = new int[n + 1]; 
        for(int i = 1; i <= n; i++){
            if(i == 1){
                solns[i] = 1; 
            }
            else if(i == 2){
                solns[i] = 2; 
            }
            else{
                solns[i] = solns[i -1] + solns[i - 2]; 
            }

        }
        return(solns[n]);
    }
    

    
}
