class Solution {
    public boolean isHappy(int n) {
        java.util.HashSet<Integer> seen = new java.util.HashSet<>(); 
        
        int sqd = ssqd(n); 
        
        while(!seen.contains(sqd)){
            if(sqd == 1){
                return true; 
            }
            seen.add(sqd); 
            sqd = ssqd(sqd); 
        }
        return false; 

    
    }
    private int ssqd(int i){
        int sum = 0; 
        String s = Integer.toString(i);
        for(char c: s.toCharArray()){
            int digit = c - '0';
            sum += (digit * digit); 
        }

        return sum; 

    }
}
