class Solution {
    public int evalRPN(String[] tokens) {
        java.util.Stack<Integer> ops = new java.util.Stack<>();
        for (int i = 0; i < tokens.length; i ++){
            String curr = tokens[i];
            if (curr.equals("+")){
                int first = ops.pop();
                int second = ops.pop();
                int sum = first + second;
                ops.push(sum);
            }
            else if (curr.equals("-")){
                int first = ops.pop();
                int second = ops.pop();
                int diff = second - first;
                ops.push(diff);

            }
            else if (curr.equals("*")){
                int first = ops.pop();
                int second = ops.pop();
                int product = second * first;
                ops.push(product);

            }
            else if (curr.equals("/")){
                int first = ops.pop();
                int second = ops.pop();
                int quotient = second / first;
                ops.push(quotient);
            }
            else{
                int num = Integer.parseInt(curr);
                ops.push(num);
            }
        }
        int result = ops.pop();
        return(result);
        
    }
}
