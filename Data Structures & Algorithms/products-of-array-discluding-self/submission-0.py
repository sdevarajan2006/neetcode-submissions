class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        #using division:
        full_product = math.prod(nums)
        ans = []
    
        for num in  nums:
            if num == 0 and nums.count(0) == 1:
                ans.append(math.prod([x for x in nums if x!= 0]))
            elif num == 0:
                ans.append(0)
            else:
                ans.append(int(full_product / num))
        
        return(ans)
        