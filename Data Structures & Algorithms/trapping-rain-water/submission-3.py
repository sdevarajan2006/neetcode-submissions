class Solution:
    def trap(self, height: List[int]) -> int:
        length = len(height)
        if length <= 2:
            return 0 

        best_left = [0] * length
        best_right = [0] * length 

        best_left[0] = height[0]
        for i in range(1,length):
            best_left[i] = max(best_left[i - 1], height[i])

        best_right[-1] = height[-1]
        for i in range(length - 2, -1, -1):
            best_right[i] = max(best_right[i + 1], height[i])

        total = 0 
        for i in range(length):
            total += min(best_left[i] , best_right[i]) - height[i]
        
        return(total)
        




        

