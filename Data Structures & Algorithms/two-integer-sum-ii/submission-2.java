class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int frontPointer = 0;
        int backPointer = numbers.length -1; 

        int[] ans = new int[2];

        while (frontPointer < backPointer){
            int frontNumber = numbers[frontPointer];
            int backNumber = numbers[backPointer];
            if (frontNumber + backNumber == target){
                ans[0] = frontPointer + 1;
                ans[1] = backPointer + 1;
                return ans;
                
            }
            if (frontNumber + backNumber > target){
                backPointer -=1;
            }
            else{
                frontPointer += 1;
            }
        }
        return(ans);        
    }
}
