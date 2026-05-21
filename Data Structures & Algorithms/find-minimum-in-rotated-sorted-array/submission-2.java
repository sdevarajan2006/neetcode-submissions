class Solution {
    public int findMin(int[] nums) {
        int currMin = Integer.MAX_VALUE; 
        int left = 0; 
        int right = nums.length - 1;

        while (left <= right){
            System.out.println(currMin);
            System.out.println(left);
            System.out.println(right);

            int mid = (right + left) /2; 
            int leftNum = nums[left];
            int rightNum = nums[right];
            int midNum = nums[mid];

            if (left + 1 == right){
                if (leftNum < currMin){
                    currMin = leftNum;
                }
                if (rightNum < currMin){
                    currMin = rightNum;
                }
                return(currMin);
            }

            // case 1: midNum less than both
            if(midNum < leftNum && midNum < rightNum){
                if(midNum < currMin){
                    currMin = midNum;
                }
                left += 1; 
                right = mid - 1;
            }
            else if (midNum > leftNum && midNum > rightNum){
                if (rightNum < currMin){
                    currMin = rightNum;
                }
                right -= 1;
                left = mid + 1;
            }
            else{ 
                if (leftNum < currMin){
                    currMin = leftNum;
                }
                return (currMin);
            }
        }
        return(currMin);
        
    }
}
