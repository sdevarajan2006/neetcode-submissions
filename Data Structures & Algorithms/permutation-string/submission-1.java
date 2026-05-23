class Solution {
    public boolean checkInclusion(String s1, String s2) {

        // get the frequencies of s1 
        java.util.HashMap<Character,Integer> frequencies1 = new java.util.HashMap<>(); 
        java.util.HashMap<Character,Integer> frequencies2 = new java.util.HashMap<>(); 

        if (s1.length() > s2.length()){
            return false;
        }

        for(int i = 0; i < s1.length(); i++){
            char c = s1.charAt(i);
            frequencies1.put(c, frequencies1.getOrDefault(c, 0) + 1);
            c = s2.charAt(i);
            frequencies2.put(c, frequencies2.getOrDefault(c, 0) + 1);
            
        }

        int left = 0; 
        int right = s1.length() - 1;

        while (left < s2.length() && right < s2.length() - 1){
            if(frequencies1.equals(frequencies2)){
                return true;
            }
            char leftChar = s2.charAt(left);
            right += 1;

            char rightChar = s2.charAt(right);
            frequencies2.put(leftChar, frequencies2.get(leftChar) - 1); 
            left += 1;
            if(frequencies2.get(leftChar) == 0){
                frequencies2.remove(leftChar);
            }
            frequencies2.put(rightChar, frequencies2.getOrDefault(rightChar, 0) + 1); 

        }

        return(frequencies1.equals(frequencies2));





        
        
    }
}
