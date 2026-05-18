class Solution {
    public int trap(int[] height) {
        // water at index i is min(tallest wall on left, tallest wall on right)  - height[i]
        int len = height.length;
        int[] tallestLeft = new int[len];
        int[] tallestRight = new int[len];


        int currTallest = height[0];
        for(int i = 1; i < len; i ++){
            tallestLeft[i] = currTallest;
            if(height[i] > currTallest){
                currTallest = height[i];
            }

        }

        currTallest = height[len -1];
        
        for(int i = len - 2; i >= 0; i--){
            tallestRight[i] = currTallest;
            if (height[i] > currTallest){
                currTallest = height[i];
            }
        }

        int currTotal = 0; 

        for(int i = 0; i < len; i++){
            int heighti = height[i];
            int leftHeight = tallestLeft[i];
            int rightHeight = tallestRight[i];
            if (leftHeight < rightHeight){
                int candidate = (leftHeight - heighti);
                if (candidate > 0){
                    currTotal += (leftHeight - heighti);
                }
            
            }
            else{
                int candidate = (rightHeight - heighti);
                if (candidate > 0){
                    currTotal += (rightHeight - heighti);
                }
                
            }
            
        }

        for (int num: tallestRight){
            System.out.println(num);
        }
        return(currTotal);

        
    }
}
