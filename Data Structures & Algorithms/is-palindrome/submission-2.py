class Solution:
    def isPalindrome(self, s: str) -> bool:
        frontpointer = 0
        backpointer = len(s) - 1

        while(frontpointer < backpointer):
            if(not s[frontpointer].isalnum() ):
                frontpointer += 1
            elif(not s[backpointer].isalnum()):
                backpointer -= 1
            elif(s[frontpointer].lower() != s[backpointer].lower()):
                return False
            else:
                frontpointer += 1
                backpointer -= 1
        
        return True