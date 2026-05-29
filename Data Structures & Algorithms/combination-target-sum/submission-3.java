class Solution {
    java.util.ArrayList<List<Integer>> ans = new java.util.ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        java.util.List<Integer> ogPath = new java.util.ArrayList<>();
        helper(nums, target, 0, 0, ogPath);
        return(ans);
        
    }

    public void helper(int[] nums, int target, int currSum, int pointer, List<Integer> path){
        if(pointer >= nums.length){
            return;
        }

        for(int i = pointer; i < nums.length; i++){
            int num = nums[i]; 
            int newSum = currSum + num;
            java.util.ArrayList<Integer> newPath = new java.util.ArrayList<>(path);
            if (newSum > target){
                continue;
            }
            newPath.add(num);
            if(newSum == target){
                ans.add(newPath);
                continue;
            }
            int newPointer = i;
            helper(nums, target, newSum, newPointer, newPath);
        }

    }
}
