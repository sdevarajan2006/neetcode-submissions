class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        java.util.HashMap<Integer, Integer> frequencies = new java.util.HashMap<>();
        for(int i = 0; i < nums.length; i ++){
            int element = nums[i];
            frequencies.put(element, frequencies.getOrDefault(element,0) + 1);
        }

        
        java.util.ArrayList<Integer> tops = new java.util.ArrayList<Integer>();

        for (int number : frequencies.keySet()){
            int frequency = frequencies.get(number);
            boolean added = false;
            int size = tops.size();
            for(int i = 0; i < size; i++){
                int currNumber = tops.get(i);
                int currFrequency = frequencies.get(currNumber);
                if (currFrequency < frequency){
                    tops.add(i, number);
                    added = true;
                    break;
                }
            }
            if (!added){
                tops.add(number);
            }

        }

        

        int[] ans = new int[k];
        for(int i = 0; i < k; i++){
            ans[i] = tops.get(i);
        }
        return(ans);
        
    }
}
