class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        d = {}
        pairs = sorted(enumerate(nums), key=lambda p: p[1])

        
        frontpointer = 0
        backpointer = len(nums ) - 1

        currSum = pairs[frontpointer][1] + pairs[backpointer][1]

        while(currSum != target):
            currSum = pairs[frontpointer][1] + pairs[backpointer][1]
            if(currSum < target): 
                frontpointer += 1
            elif (currSum > target):
                backpointer -= 1
        
        x = pairs[frontpointer][0] 
        y = pairs[backpointer][0]
        return[min(x,y), max(x,y)]
        
        