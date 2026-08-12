class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        longest_prefix = strs[0]
        currIndex = 0 
        while(currIndex < len(strs)):
            if(strs[currIndex][:len(longest_prefix)] != longest_prefix):
                longest_prefix = longest_prefix[: -1]
            else:
                currIndex += 1
        

        return longest_prefix
        