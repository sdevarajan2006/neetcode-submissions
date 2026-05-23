class Solution {
    public int lengthOfLongestSubstring(String s) {
        // idea : keep a rolling hashmap of what characters we have encountered so far 

        int left = 0; 
        int right = 0; 
        int currLongest = 0;

        java.util.HashMap<Character, Integer> freqs = new java.util.HashMap<>();

        while (left  < s.length() && right < s.length()){
            char newChar = s.charAt(right);
            
            if (freqs.containsKey(newChar)){
                currLongest = Math.max(currLongest, freqs.size());
                char leftChar = s.charAt(left);
                freqs.remove(leftChar);
                left += 1;

            }
            else{
                freqs.put(newChar, 1);
                right += 1;
            }

        }
        currLongest = Math.max(currLongest, freqs.size());
        return(currLongest);



    
        
    }
}
