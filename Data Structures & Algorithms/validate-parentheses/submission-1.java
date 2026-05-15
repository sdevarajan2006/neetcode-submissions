

class Solution {
    
    public boolean isValid(String s) {
        java.util.Stack<Character> stack = new java.util.Stack<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '['){
                stack.push(c);
            }
            else{
                if (stack.isEmpty()){
                    
                    System.out.println("1");
                    return false;
                }
                char top = stack.pop();
                if (c == ')' && top != '('){
                    System.out.println("2");
                    return false;
                }
                if (c == ']' && top != '['){
                    
                    System.out.println("3");
                    return false;
                }
                if (c == '}' && top != '{'){
                    
                    System.out.println("4");
                    return false;
                }

            }
        }

        return(stack.size() == 0);
        
        
    }
}
