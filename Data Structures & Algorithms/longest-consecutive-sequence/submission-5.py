class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        sorted_nums = sorted(nums)
        max_length = 0 
        curr_length = 1

        if nums == []:
            return 0

        if len(nums) == 1:
            return 1

        for i in range(len(sorted_nums) - 1):
            if sorted_nums[i] == sorted_nums[i + 1]:
                continue
            if sorted_nums[i] + 1 == sorted_nums[i + 1]:
                curr_length += 1
            else: 
                # this means that we need to reset counter 
                max_length = max(max_length, curr_length)
                curr_length = 1

        max_length = max(max_length, curr_length) 
        return(max_length) 