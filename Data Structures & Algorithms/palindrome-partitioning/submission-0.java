class Solution {
    java.util.List<List<String>> ans = new java.util.ArrayList<>(); 


    public List<List<String>> partition(String s) {
        java.util.List<String> ogString = new java.util.ArrayList<>();
        helper(s, 0, ogString);  
        return(ans);  
    }
    
    public void helper(String s, int start,  List<String> soFar){ 
        if (start == s.length()) {
            ans.add(new ArrayList<>(soFar));
            return;
        }
        
        // given that the String indexed at i, j is already a palindrome 
        for(int end = start; end < s.length(); end++){
            if(isPalindrome(s, start, end)){
                String toAdd = s.substring(start, end + 1);
                soFar.add(toAdd);
                helper(s, end + 1, soFar);
                soFar.remove(soFar.size() -1);
            }
        }
    }

    public boolean isPalindrome(String s, int left, int right){
        while(left < right){
            char leftChar = s.charAt(left); 
            char rightChar = s.charAt(right); 
            if (leftChar != rightChar){
                return false;
            }
            left += 1; 
            right -= 1; 
        }
        return true; 
    }

    

}
