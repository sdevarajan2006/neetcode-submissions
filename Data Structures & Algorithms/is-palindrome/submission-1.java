class Solution {
    public boolean isPalindrome(String s) {
        int frontPointer = 0;
        int backPointer = s.length() - 1;

        while(frontPointer < backPointer){
            char frontCharacter = s.charAt(frontPointer);
            char backCharacter = s.charAt(backPointer);
            if (!Character.isLetterOrDigit(frontCharacter)){
                frontPointer += 1;
            }
            else if (!Character.isLetterOrDigit(backCharacter)){
                backPointer -= 1;
            }
            else if (!(Character.toLowerCase(frontCharacter) == Character.toLowerCase(backCharacter))){
                System.out.println(Character.toLowerCase(frontCharacter));
                System.out.println(Character.toLowerCase(backCharacter));
                
                return false;
            }
            else{
                frontPointer += 1;
                backPointer -= 1;
            }
        }
        return true;
        
    }
}
