class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        dicty1 = {}
        dicty2 = {}

        for char in s :
            dicty1[char] = dicty1.get(char,0) + 1
        
        for char in t:
            dicty2[char] = dicty2.get(char, 0) + 1

        for key in dicty1: 
            if(dicty1.get(key, 0) != dicty2.get(key, 0)):
                return False
        

        for key in dicty2: 
            if(dicty1.get(key, 0) != dicty2.get(key, 0)):
                return False
        
        return True
    
        