class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        #list of lists containing o/p 
        buckets = []
        for strr in strs:
            found = False
            for i in range(len(buckets)):
                if self.isAnagram(buckets[i][0], strr):
                    buckets[i].append(strr)
                    found = True
                    break
            if not found:
                buckets.append([strr])
        return(buckets)
    
    def isAnagram(self, s: str, t: str) -> bool:
        s_sorted = sorted(s) 
        t_sorted = sorted(t)
        return(s_sorted == t_sorted)
