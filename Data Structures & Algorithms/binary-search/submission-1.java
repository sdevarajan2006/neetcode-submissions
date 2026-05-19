class Solution {
    public int search(int[] nums, int target) {
        int leftPointer = 0;
        int rightPointer = nums.length - 1;


        while (leftPointer <= rightPointer){
            int mid = (leftPointer + rightPointer) / 2;
            int middleNumber = nums[mid];

            if (middleNumber < target){
                leftPointer = mid + 1;
            }
            else if (middleNumber > target){
                rightPointer = mid - 1;
            }
            else{
                return mid;
            }




        }
        return -1;

        


        
    }
}
