class Solution {
    public int maxProduct(int[] nums) {
        // max - maximum produt of a subarray ending at the current index;
        // min- minimum product of a subarray ending at the current index; 
        // result - the best max seen across all indices so far ; 

        
        int max = nums[0]; 
        int min = nums[0];
        int result = nums[0]; 

        // int[] dp = new int[nums.length]; 

        for(int i = 1; i < nums.length; i++){
            int curr = nums[i]; 
            int tm = Math.max(curr, Math.max(curr * max, curr * min)); 
            min = Math.min(curr, Math.min(curr * max, curr * min)); 
            max = tm; 
            result = Math.max(result, max); 

        }
        
        return(result); 

    }
}
