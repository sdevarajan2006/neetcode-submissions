class Solution {
    public int maxProfit(int[] prices) {
        int[][] r = new int[2][prices.length]; // row 1 = true, row 2 = false; 
        for(int i = 0; i < r.length; i++){
            for(int j = 0; j < r[0].length; j++){
                r[i][j] = Integer.MIN_VALUE; 
            }
        }

        return helper(prices, 0, 1, r); 
    }

    public int helper(int[] prices,int i, int holding, int[][] r){
        
        if (i >= prices.length) return 0;              // guard runs first
        if (r[holding][i] != Integer.MIN_VALUE) return r[holding][i];

        int result;
        if (holding == 0) {
            result = Math.max(prices[i] + helper(prices, i + 2, 1, r),
                              helper(prices, i + 1, 0, r));
        } else {
            result = Math.max(-prices[i] + helper(prices, i + 1, 0, r),
                              helper(prices, i + 1, 1, r));
        }

        r[holding][i] = result;
        return result;
    }

    
}
