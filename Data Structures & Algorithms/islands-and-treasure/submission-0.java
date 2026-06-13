class Solution {
    public void islandsAndTreasure(int[][] grid) {
        java.util.Queue<int[]> q = new java.util.ArrayDeque<>(); 

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                // if it is a treasure : 
                if(grid[i][j] == 0 ){
                    int[] newInt = new int[2];
                    newInt[0] = i; 
                    newInt[1] = j;
                    q.add(newInt);
                }
            }
        }

        while(q.size() > 0){
            int[] elem = q.poll();
            int row = elem[0]; 
            int col = elem[1];

            int gridVal = grid[row][col]; 

            // 2 things to check : in bounds and is not and is an unvisited land cell 
            if(goodChecker(row + 1, col, grid)){
                grid[row + 1][col] = gridVal + 1; 
                int[] toAdd = new int[2];
                toAdd[0] = row + 1;
                toAdd[1] = col; 
                q.add(toAdd);
            }
            if(goodChecker(row -1, col, grid)){
                grid[row -  1][col] = gridVal + 1; 
                int[] toAdd = new int[2];
                toAdd[0] = row - 1;
                toAdd[1] = col; 
                q.add(toAdd);
            }
            if(goodChecker(row , col + 1, grid)){
                grid[row][col + 1] = gridVal + 1; 
                int[] toAdd = new int[2];
                toAdd[0] = row ;
                toAdd[1] = col + 1; 
                q.add(toAdd);
            }
            if(goodChecker(row , col - 1, grid)){
                grid[row][col - 1] = gridVal + 1; 
                int[] toAdd = new int[2];
                toAdd[0] = row ;
                toAdd[1] = col - 1; 
                q.add(toAdd);
            }
            
        }
        
        
    }
    public boolean goodChecker(int row, int col, int[][] grid){
        if(row < 0 || row >= grid.length){
            return false;
        }
        if(col < 0 || col >= grid[0].length){
            return false; 
        }
        if (grid[row][col] != Integer.MAX_VALUE){
            return false;
        }
        return true;

    }
}
