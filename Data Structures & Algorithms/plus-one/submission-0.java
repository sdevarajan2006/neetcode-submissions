class Solution {
    public int[] plusOne(int[] digits) {
        
        boolean expand = false; 
        digits[digits.length - 1] = digits[digits.length - 1] + 1; 
        for(int i = digits.length - 1; i >= 0; i--){
            if(digits[i] == 10){
                digits[i] = 0; 
                if(i == 0){
                    expand = true; 
                }
                else{
                    digits[i - 1] = digits[i -1] + 1; 
                }
            }
            else{
                i = -1; 
            } 

        }
        if (expand){
            int[] neww = new int[digits.length + 1]; 
            neww[0] = 1; 
            for(int i = 0; i < digits.length; i++){
                neww[i + 1] = digits[i]; 
            }
            return neww;
        }
        return digits; 
            
    
        
    }
}
