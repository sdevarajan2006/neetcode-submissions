class Solution {

    public String encode(List<String> strs) {
        if (strs.size() == 0){
            return "raiseyouryayaya";
        }

        String ans = "";
        for (String s: strs){
            ans = ans + s;
            ans = ans + "€";
        }
        return ans;

        

    }

    public List<String> decode(String str) {
        java.util.ArrayList<String> ans = new java.util.ArrayList<>();
        if (str == "raiseyouryayaya"){
            return ans;
        }

        String currStr = "";
        for (char c : str.toCharArray()){
            if (c == '€'){
                ans.add(currStr);
                currStr = "";
            }
            else{
                currStr = currStr + c;
            }

        }
        
        return(ans);

    }
}
