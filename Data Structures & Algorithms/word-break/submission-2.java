class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // put wordDict into a set 
        java.util.HashSet<String> wd = new java.util.HashSet<>();
        java.util.HashSet<String> failed = new java.util.HashSet<>(); 
        for(String x: wordDict){
            wd.add(x); 
        } 

        return(isValid(s, wd, failed)); 

    }

    public boolean isValid(String word, Set<String> wd, Set<String> failed){
        if(wd.contains(word)){
            return(true); 
        }
        if(failed.contains(word)){
            return false; 
        }
        for(int i = word.length() - 1; i >= 0; i--){
            String w1 = word.substring(0, i + 1); 
            if(wd.contains(w1)){
                String w2 = word.substring(i + 1, word.length()); 
                if(isValid(w2, wd, failed)){
                    return true; 
                }
                else{ 
                    failed.add(w2); 
                }
            }
        }
        return false; 

    }


}
