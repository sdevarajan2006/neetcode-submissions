class Solution {
    public int countSubstrings(String s) {
        int counter = 0;

        for(int i = 0; i < s.length(); i ++){
            counter += numPalidromes(s,i, i); 
            counter += numPalidromes(s,i, i + 1);
        } 
        return(counter); 
        
    }

    public int numPalidromes(String s, int left, int right){
        int count = 0; 

        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            count += 1; 
            left -= 1; 
            right += 1; 
        }
        return count; 
        
        
    }
}
