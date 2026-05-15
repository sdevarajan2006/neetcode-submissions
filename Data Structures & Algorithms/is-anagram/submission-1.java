class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        java.util.HashMap<Character, Integer> sFrequencies = new HashMap<>();
        java.util.HashMap<Character, Integer> tFrequencies = new HashMap<>();

        for(int i = 0; i < s.length(); i ++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            sFrequencies.put(sChar, sFrequencies.getOrDefault(sChar,0) + 1);
            tFrequencies.put(tChar, tFrequencies.getOrDefault(tChar, 0) + 1);

        }

        return(sFrequencies.equals(tFrequencies));


    }
}
