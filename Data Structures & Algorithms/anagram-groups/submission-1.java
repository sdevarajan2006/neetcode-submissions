class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        java.util.HashMap<String, List<String>> buckets = new java.util.HashMap<>();

        for (String s: strs){
            boolean put = false;
            for (String t: buckets.keySet()){
                if (isAnagram(s,t)){
                    buckets.get(t).add(s);
                    put = true;
                    break;
                }
            }
            if (put == false){
                List<String> stuff = new ArrayList<>();
                stuff.add(s);
                buckets.put(s, stuff);

            }

        }

        int numElements = buckets.size();
        List<List<String>> ans = new ArrayList<>();
        for(String x : buckets.keySet()){
            List<String> bucket = buckets.get(x);
            ans.add(bucket);
        }
        return(ans);

        
    }

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
