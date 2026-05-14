class Solution:
    def maxArea(self, heights: List[int]) -> int:
        best_area = 0 
        front_pointer = 0 
        back_pointer = len(heights) - 1

        while front_pointer < back_pointer:
            front_height = heights[front_pointer]
            back_height = heights[back_pointer]
            width = back_pointer - front_pointer
            height = min(back_height, front_height)
            area = width * height 
            best_area = max(best_area, area)
            if front_height < back_height:
                front_pointer += 1
            else:
                back_pointer -= 1
        
        return(best_area)
        