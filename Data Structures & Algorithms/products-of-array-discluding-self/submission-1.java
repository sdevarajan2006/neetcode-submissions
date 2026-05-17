class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] toTheLeft = new int[nums.length];
        int[] toTheRight = new int[nums.length];

        int currentProduct = 1;
        for (int i = 0; i < nums.length; i++){
            toTheLeft[i] = currentProduct;
            currentProduct *= nums[i];
        }

        currentProduct = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            toTheRight[i] = currentProduct;
            currentProduct *= nums[i];
        }

        int[] ans = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            ans[i] = toTheLeft[i] * toTheRight[i];
        }
        return ans;
        
    }
}  
