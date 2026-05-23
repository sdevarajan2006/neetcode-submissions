class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0; 
        int right = 0;
        int maxLength = 0; 

        java.util.HashMap<Character, Integer> frequencies = new java.util.HashMap<>(); 
        int length = 1;
        while(left < s.length() && right < s.length()){
            
            
            char rightChar = s.charAt(right);
            frequencies.put(rightChar, frequencies.getOrDefault(rightChar, 0) + 1);
            length = right - left + 1; 
            int maxFrequency = Collections.max(frequencies.values());
            
            int replacements = length - maxFrequency;
            
            if (replacements > k){
                maxLength = Math.max(maxLength, length - 1);
                char leftChar = s.charAt(left);
                frequencies.put(leftChar, frequencies.get(leftChar) - 1);
                frequencies.put(rightChar, frequencies.get(rightChar) - 1);
                left += 1;
                if (right == s.length() - 1){
                    return(maxLength);
                }
                System.out.println(left);
                System.out.println(leftChar);
                System.out.println(frequencies.get(leftChar));
                System.out.println(Collections.max(frequencies.values()));

                
            }
            else{
                right += 1;
            }



        }

        maxLength = Math.max(maxLength, length);
        return(maxLength);
        
    }
}
