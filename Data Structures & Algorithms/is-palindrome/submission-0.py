class Solution:
    def isPalindrome(self, s: str) -> bool:
        front_index = 0 
        back_index = len(s) - 1

        while front_index < back_index:
            front_character = s[front_index].lower()
            back_character = s[back_index].lower()
            
            if (not(front_character.isalnum())):
                front_index += 1
            elif (not(back_character.isalnum())):
                back_index -= 1
            else:
                if (front_character != back_character):
                    return False
                front_index += 1
                back_index -= 1
            

        return True 

        