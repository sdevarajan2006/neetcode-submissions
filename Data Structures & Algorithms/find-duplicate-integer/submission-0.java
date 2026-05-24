class Solution {
    public int findDuplicate(int[] nums) {
        java.util.HashMap<Integer, Integer> frequencies = new java.util.HashMap<>();

        for (int i = 0; i < nums.length; i++){
            int number = nums[i];
            if (frequencies.containsKey(number)){
                return number;
            }
            frequencies.put(number, 1);
        }

        return(-1);
        
    }
}
