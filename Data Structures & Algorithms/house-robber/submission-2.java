class Solution {
    public int rob(int[] nums) {
        int[] ans = new int[nums.length]; 
        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                ans[i] = nums[i]; 
            }
            else if(i == 1){
                ans[i] = Math.max(nums[0], nums[1]); 
            }
            else{
                int num = nums[i]; 
                ans[i] = Math.max(ans[i - 1], ans[i -2] + num);
            }
        }
        return(ans[ans.length -1]);


        
    }
    
}
