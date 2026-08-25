class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // start by finding the single closest element, and slide indices outwards until we have a range of length k. 

        int minDex = 0; 


        for(int i = 0; i < arr.length; i++){
            if(Math.abs(x - arr[i]) < Math.abs(x - arr[minDex])){
                minDex = i; 
            }
        }

        int currLength = 1; 
        int left = minDex;
        int right = minDex; 

        while(right - left + 1 < k){

            int nl = left - 1; 
            int nr = right + 1; 


            if(nl >= 0 && nr < arr.length){
                int nlVal = Math.abs( arr[nl] - x); 
                int nrVal = Math.abs( arr[nr] - x); 
                
                if (nlVal <= nrVal){
                    left -= 1; 
                }
                else{
                    right += 1; 
                }

            }
            else if(nl >= 0){
                left -= 1; 

            }
            else if (nr < arr.length){
                right += 1; 
                
            }
            else{
                break; 
            }

        }

        java.util.ArrayList<Integer> ans = new java.util.ArrayList<>(); 
        for(int i = left; i <= right; i++){
            ans.add(arr[i]);
        }

        return ans; 
        
    }
}