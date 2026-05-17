class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // approach - two sum with the target as -1 * value

        java.util.Arrays.sort(nums);
        

        // turn nums into an arraylist 
        ArrayList<Integer> numsAl = new java.util.ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int number = nums[i];
            numsAl.add(number);
        }

        List<List<Integer>> ans = new java.util.ArrayList<>();

        for(int i = 0; i < numsAl.size(); i++){
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            int currentNumber = nums[i];
            
            List<Integer> currlist = numsAl.subList(i + 1, numsAl.size());
            
            List<int[]> twoSums = twoSum(currlist, currentNumber * -1);
            
            for(int[] soln : twoSums){
                List<Integer> sol = new java.util.ArrayList<>();
                sol.add(currentNumber);
                sol.add(soln[0]);
                sol.add(soln[1]);
                ans.add(sol);
            }


        }
        return(ans);

        
    }

    public List<int[]> twoSum(List<Integer> numbers, int target) {

        int frontPointer = 0;
        int backPointer = numbers.size() -1; 

        List<int[]> ans = new java.util.ArrayList<>();
        

        while (frontPointer < backPointer){
            
            int frontNumber = numbers.get(frontPointer);
            int backNumber = numbers.get(backPointer);
            if (frontNumber + backNumber == target){
                int[] a = new int[2];
                a[0] = frontNumber;
                frontPointer += 1;
                a[1] = backNumber;
                backPointer -= 1;
                ans.add(a);

                while (frontPointer < backPointer && numbers.get(frontPointer) == frontNumber) {
                frontPointer++;
                }

                while (frontPointer < backPointer && numbers.get(backPointer) == backNumber) {
                backPointer--;
                }
                
            }
            else if (frontNumber + backNumber > target){
                backPointer -= 1;
            }
            else{
                frontPointer += 1;
            }
        }
        return(ans);        
    }


}
