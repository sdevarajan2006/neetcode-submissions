class Solution {
    java.util.List<List<Integer>> ans = new java.util.ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        java.util.Arrays.sort(nums);
        java.util.List<Integer> ogPath = new java.util.ArrayList<>(); 
        helper(nums, 0, ogPath); 
        return(ans);

        
    }

    public void helper(int[] nums, int pointer, List<Integer> path){
        ans.add(new java.util.ArrayList<>(path));
        if(pointer >= nums.length){
            return;
        }
        for (int i = pointer; i < nums.length; i++) { 
            if (i > pointer && nums[i] == nums[i - 1]) continue; 
            path.add(nums[i]);
            helper(nums, i + 1, path);
            path.remove(path.size() - 1); 
        }

    }
}
