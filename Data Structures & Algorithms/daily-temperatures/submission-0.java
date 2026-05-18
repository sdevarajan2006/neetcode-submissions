class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        java.util.Stack<int[]> temps = new java.util.Stack<>();
        int i = 0;
        while (i < temperatures.length){
            int currentTemperature = temperatures[i]; 
            if(temps.size() == 0){
                int[] toAdd = new int[2]; 
                toAdd[0] = i;
                toAdd[1] = currentTemperature;
                i += 1;
                temps.push(toAdd);
            }
            else{
                int[] elem = temps.peek();
                int thatIndex = elem[0];
                int thatTemp = elem[1];
                if (thatTemp < currentTemperature){
                    ans[thatIndex] = i - thatIndex;
                    temps.pop();
                }
                else{
                    int[] toAdd = new int[2]; 
                    toAdd[0] = i;
                    toAdd[1] = currentTemperature;
                    i += 1;
                    temps.push(toAdd);
                }
            }  
    }
    return(ans);

}}
