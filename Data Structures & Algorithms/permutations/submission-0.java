class Solution {
    java.util.List<List<Integer>> ans = new java.util.ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        // nums into arrayList 
        java.util.List<Integer> numsAl = new java.util.ArrayList<>();
        for (int num: nums){
            numsAl.add(num); 
        }
        java.util.List<Integer> ogPermSoFar = new java.util.ArrayList<>();
        helper(numsAl, ogPermSoFar); 
        return(ans);




        
    }

    public void helper(List<Integer> whatsLeft, List<Integer> permSoFar){ 
        // base case 
        if (whatsLeft.size() == 0){
            ans.add(permSoFar);
        }

        for (int i = 0; i < whatsLeft.size(); i++){
            int elem = whatsLeft.get(i); 
            java.util.List<Integer> psfCopy = new java.util.ArrayList<>(permSoFar); 
            java.util.List<Integer> wlCopy = new java.util.ArrayList<>(whatsLeft);
            wlCopy.remove(i); 
            psfCopy.add(elem); 
            helper(wlCopy, psfCopy); 


        }
        

    }
}
