class Solution {
    public boolean hasDuplicate(int[] nums) {
        java.util.HashMap<Integer, Integer> counts = new java.util.HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int num = nums[i];
            if (counts.containsKey(num)){
                return true;
            }
            counts.put(num, 1);
        }
        return false;

        
    }
}