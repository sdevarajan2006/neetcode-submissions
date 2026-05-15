class Solution {
    public int[] twoSum(int[] nums, int target) {
        // hashmap approach - find the frequencies of 
        // each of the numbers and then iterate to find 
        // a potential match 

        java.util.HashMap<Integer, Integer> frequencies = new java.util.HashMap<>();

        for(int i = 0; i < nums.length; i ++){
            int num = nums[i];
            frequencies.put(num, frequencies.getOrDefault(num, 0) + 1);
        }
        // frequency table is built out 

        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            int difference = target - num ;
            if (difference == num){
                int value = frequencies.get(num);
                if (value <= 1){
                    continue;
                }
            }
            else{
                if (frequencies.containsKey(difference) == false){
                    continue;
                }
            }

            for (int j = i + 1; j < nums.length; j++){
                if(nums[j] == difference){
                    int[] toReturn = new int[2];
                    toReturn[0] = i;
                    toReturn[1] = j;
                    return toReturn;
                    
                }
            }
        }

        int[] failure = new int[2];
        return(failure);




        
    }
}
