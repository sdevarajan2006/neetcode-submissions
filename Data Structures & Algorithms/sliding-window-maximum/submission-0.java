class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        java.util.HashMap<Integer, Integer> frequencies = new java.util.HashMap<>();
        int left = 0;
        int right = k - 1; 

        int[] ans = new int[nums.length - k + 1];

        for(int i = left; i <= right; i++){
            int num = nums[i];
            frequencies.put(num, frequencies.getOrDefault(num, 0 ) + 1);
        }
        

        while(left < nums.length - 1 && right < nums.length - 1){
            
            ans[left] = Collections.max(frequencies.keySet());
            
            // remove left Side 
            int leftNum = nums[left];
            if (frequencies.get(leftNum) == 1){
                frequencies.remove(leftNum);
            }
            else{
                frequencies.put(leftNum, frequencies.get(leftNum) -1);
            }
            left += 1;

            right += 1; 
            // add right side

            int rightNum = nums[right];
            frequencies.put(rightNum, frequencies.getOrDefault(rightNum, 0) + 1);

            
            

        }
        ans[left] = Collections.max(frequencies.keySet());

        return(ans);
        
    }
}
