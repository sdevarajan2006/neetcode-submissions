class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        my_set = set(nums)
        dicty = {}
        for num in my_set:
            dicty[num] = nums.count(num)
        
        dicty_sorted = sorted(dicty, key = dicty.get, reverse = True)
        return(dicty_sorted[:k])

        