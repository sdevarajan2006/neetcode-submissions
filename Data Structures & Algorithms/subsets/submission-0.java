class Solution {
    java.util.List<List<Integer>> ans = new java.util.ArrayList<>();
    int[] n;
    public List<List<Integer>> subsets(int[] nums) {
        n = nums;
        helper(new java.util.ArrayList<>(), 0);
        return ans;
        

        
    }

    public void helper(List<Integer> path, int pointer){
        ans.add(new java.util.ArrayList<>(path));
        if(pointer == n.length){
            return;
        }
        for(int i = pointer; i < n.length; i++){
            path.add(n[i]);
            helper(path, i + 1);
            path.remove(Integer.valueOf(n[i]));
        }
    }
}
