class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        front_index = 0 
        back_index = len(numbers) - 1

        while front_index < back_index:
            front_num = numbers[front_index]
            back_num = numbers[back_index]
            if (front_num + back_num == target):
                return([front_index + 1, back_index + 1])
            elif (front_num + back_num < target):
                front_index += 1
            else:
                back_index -= 1
        
        return("couldn't find")