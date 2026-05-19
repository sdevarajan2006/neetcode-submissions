class Solution {
    public int largestRectangleArea(int[] heights) {
        java.util.Stack<int[]> stacky = new java.util.Stack<>();
        int currBest = 0;

        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            int start = i;

            while (!stacky.isEmpty() && stacky.peek()[1] > height) {
                int[] top = stacky.pop();
                int topStart = top[0];
                int topHeight = top[1];

                int width = i - topStart;
                int area = width * topHeight;
                currBest = Math.max(currBest, area);

                // current shorter bar can extend back to where popped bar started
                start = topStart;
            }

            stacky.push(new int[]{start, height});
        }

        int rightIndex = heights.length;

        while (!stacky.isEmpty()) {
            int[] top = stacky.pop();
            int start = top[0];
            int height = top[1];

            int width = rightIndex - start;
            int area = width * height;
            currBest = Math.max(currBest, area);
        }

        return currBest;
    }
}