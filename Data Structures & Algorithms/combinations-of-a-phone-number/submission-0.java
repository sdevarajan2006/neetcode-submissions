class Solution {
    java.util.HashMap<Character, List<Character>> d = new java.util.HashMap<>();
    java.util.List<String> ans = new java.util.ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.equals("")){
            return ans;
        }
        createDict();
        String ogPath = "";
        helper(digits, 0 , ogPath);
        return(ans);        
    }

    public void helper(String digits, int pointer, String path){
        // base case
        if (pointer == digits.length()){
            String toAdd = new String(path);
            ans.add(toAdd);
            return;
        }
        char numAtPointer = digits.charAt(pointer); 
        List<Character> chars = d.get(numAtPointer);
        for(int i = 0; i < chars.size(); i ++){
            char c = chars.get(i);
            path += c; 
            helper(digits, pointer + 1, path);
            path = path.substring(0, path.length() - 1);
        }
        
    }

    public void createDict(){
        java.util.ArrayList<Character> l2 = new java.util.ArrayList<>(java.util.Arrays.asList('a','b','c'));
        java.util.ArrayList<Character> l3 = new java.util.ArrayList<>(java.util.Arrays.asList('d','e','f'));
        java.util.ArrayList<Character> l4 = new java.util.ArrayList<>(java.util.Arrays.asList('g','h','i'));
        java.util.ArrayList<Character> l5 = new java.util.ArrayList<>(java.util.Arrays.asList('j','k','l'));
        java.util.ArrayList<Character> l6 = new java.util.ArrayList<>(java.util.Arrays.asList('m','n','o'));
        java.util.ArrayList<Character> l7 = new java.util.ArrayList<>(java.util.Arrays.asList('p','q','r','s'));
        java.util.ArrayList<Character> l8 = new java.util.ArrayList<>(java.util.Arrays.asList('t','u','v'));
        java.util.ArrayList<Character> l9 = new java.util.ArrayList<>(java.util.Arrays.asList('w','x','y','z'));
        d.put('2', l2);
        d.put('3', l3);
        d.put('4', l4);
        d.put('5', l5);
        d.put('6', l6);
        d.put('7', l7);
        d.put('8', l8);
        d.put('9', l9);
        


    }
}
