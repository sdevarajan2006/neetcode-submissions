class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0; 
        int minPriceSoFar = prices[0];

        for(int i = 1; i < prices.length; i++){
            int sellingPrice = prices[i];
            int profit = sellingPrice - minPriceSoFar;
            maxProfit = Math.max(profit,maxProfit);
            minPriceSoFar  = Math.min(minPriceSoFar, sellingPrice); 
        }

        return(maxProfit);


        
    }
}
