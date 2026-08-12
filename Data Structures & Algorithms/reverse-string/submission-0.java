class Solution {
    public void reverseString(char[] s) {
        int frontPointer = 0; 
        int backPointer = s.length - 1; 

        while(frontPointer < backPointer){
            char temp = s[frontPointer];
            s[frontPointer] = s[backPointer]; 
            s[backPointer] = temp; 
            frontPointer += 1; 
            backPointer -= 1; 
        }

        
    }
}