class Solution {
    public int maxArea(int[] heights) {
        int frontPointer = 0;
        int backPointer = heights.length - 1;
        int maxArea = 0;

        while(frontPointer < backPointer){
            int frontHeight = heights[frontPointer];
            int backHeight = heights[backPointer];
            int currentArea;
            if (frontHeight < backHeight){
                currentArea  = (backPointer - frontPointer) * frontHeight;
                frontPointer += 1;

            }
            else{
                currentArea  = (backPointer - frontPointer) * backHeight;
                backPointer -= 1;



            }

            if (maxArea < currentArea){
                maxArea = currentArea;
            }



        }
        return(maxArea);

        
        
    }
}
