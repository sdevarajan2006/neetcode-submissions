class MinStack {

    java.util.Stack<Integer> stack;
    java.util.Stack<Integer> minHistory;

    public MinStack() {
        stack = new java.util.Stack<>();
        minHistory = new java.util.Stack<>();


        
    }
    
    public void push(int val) {
        if (minHistory.size() == 0){
            minHistory.push(val);
        }
        else {
            int recentmin = minHistory.peek();
            if (recentmin >= val){
                minHistory.push(val);
            }
        }
    
        stack.push(val);
        
    }
    
    public void pop() {
        int popped = stack.pop();
        if (popped == minHistory.peek()){
            minHistory.pop();
        }

        
    }
    
    public int top() {
        return(stack.peek());
        
    }
    
    public int getMin() {
        return minHistory.peek();
        
    }
}
