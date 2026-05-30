class Solution {
    java.util.List<List<Integer>> ans = new java.util.ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        java.util.Arrays.sort(candidates);
        int i = 0;
        while(i < candidates.length){
            List<Integer> ogPath = new java.util.ArrayList<>();
            helper(candidates, i, target, 0, ogPath);

            int j = i + 1; 
            boolean done = false;
            while(j < candidates.length && !done){
                if(candidates[i] == candidates[j]){
                    j += 1;
                }
                else{
                    done = true;
                }
            }
            i = j;

        }
            
        return(ans);
        
    }

    public void helper(int[] candidates, int pointer, int target, int currSum, List<Integer> path){
        if(pointer >= candidates.length){
            return;
        }
        int newSum = currSum + candidates[pointer]; 
        List<Integer> newPath = new java.util.ArrayList<>(path); 
        newPath.add(candidates[pointer]);
        if (newSum == target){
            ans.add(newPath);
            return;
        }
        if (pointer == candidates.length - 1){
            return;
        }
        if (newSum > target){
            return;
        }
        int i = pointer + 1; 
        while(i < candidates.length){
            helper(candidates, i, target, newSum, newPath); 
            int j = i + 1; 
            boolean done = false;
            while(j < candidates.length && !done){
                if(candidates[i] == candidates[j]){
                    j += 1;
                }
                else{
                    done = true;
                }
            }
            i = j;
        }

    }
}
