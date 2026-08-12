class Solution {
    public int removeElement(int[] nums, int val) {
        int indexToFill = 0; 
        int indexParsed = 0;
        

        while(indexToFill < nums.length && indexParsed < nums.length){
            if(nums[indexParsed] != val){
                nums[indexToFill] = nums[indexParsed]; 
                indexToFill += 1; 
                indexParsed += 1; 
            }
            else{ 
                indexParsed += 1; 
            }
        }

        return(indexToFill); 

        
    }
}