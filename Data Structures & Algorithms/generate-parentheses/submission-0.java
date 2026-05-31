class Solution {
    int maxLength; 
    List<String> ans = new java.util.ArrayList<>();
    public List<String> generateParenthesis(int n) {
        maxLength = n;
        String ogPath = "";
        helper(0,0,0,ogPath);
        return(ans);
        
    }

    public void helper(int open, int close, int lengthSoFar, String path){ 

        // if close > open becomes invalid 
        if (close > open){
            return;
        }
        if (close == open && close != 0 && close == maxLength){
            ans.add(new String(path));
        }
        if (close > maxLength || open > maxLength){ 
            return;
        }


        // try an open parentheses 
        path += "(";
        helper(open + 1, close, lengthSoFar + 1, path); 
        path = path.substring(0, path.length() - 1);
        path += ")";
        helper(open, close + 1, lengthSoFar + 1, path); 
        return;
    }
    }


