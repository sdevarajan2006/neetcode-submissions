class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        d = {} 

        for s in strs: 
            inserted = False
            for k in d: 
                if self.isAnagram(k , s) : 
                    d[k].append(s)
                    inserted = True
            if(inserted == False):
                d[s] = [s]

        ans = []
        for k in d: 
            ans.append(d.get(k))    

        return ans    


    
    
    def isAnagram(self, s1, s2):
        dicty1 = {}
        dicty2 = {}

        for char in s1:
            dicty1[char] = dicty1.get(char, 0) + 1
        for char in s2: 
            dicty2[char] = dicty2.get(char, 0 ) + 1
        

        for key in dicty1:
            if(dicty1.get(key, 0) != dicty2.get(key,0)):
                return False
        
        for key in dicty2:
            if(dicty1.get(key, 0) != dicty2.get(key,0)):
                return False
        
        return True
        