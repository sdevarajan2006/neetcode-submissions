class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        op = []
        for i in range(len(nums)):
            nummy = nums[i]
            targ = -1 * nummy 
            spliced = nums[i + 1:]
            ans = self.targetedIntegerSum(targ, spliced)
            if (len(ans) != 0):
                for an in ans: 
                    triplet = [nummy, spliced[an[0]], spliced[an[1]]]
                    if not(triplet in op):
                        op.append(triplet)
        return(op)


    

    def targetedIntegerSum(self, target, numsadj):
        front_index = 0 
        back_index = len(numsadj) - 1
        answers = []

        while front_index < back_index:
            front_num = numsadj[front_index] 
            back_num = numsadj[back_index]
            summy = front_num + back_num
            if (summy == target):
                answers.append([front_index, back_index])
                front_index += 1
                back_index -= 1
            elif (summy < target):
                front_index += 1
            else:
                back_index -= 1
        return(answers)       