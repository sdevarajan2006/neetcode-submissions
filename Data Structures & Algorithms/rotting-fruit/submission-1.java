class Solution {
    public int orangesRotting(int[][] grid) {
        // perform a BFS from every rotten fruit. update time by when the last fresh fruit became rotten
        java.util.Queue<int[]> q = new java.util.ArrayDeque<>(); 
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    int[] ar = makeArray(i, j, 0);
                    q.add(ar);
                }

            }
        }

        int time = 0; 
        while(q.size() > 0){
            int[] item = q.poll(); 
            int r = item[0]; 
            int c = item[1];
            int t = item[2];
            time = Math.max(time, t); 

            if(isGood(r + 1, c, grid)){
                int[] ar = makeArray(r + 1, c, t + 1);
                grid[r+1][c] = 2;
                q.add(ar);
            }
            if(isGood(r - 1, c, grid)){
                int[] ar = makeArray(r - 1, c, t + 1);
                grid[r-1][c] = 2;
                q.add(ar);
            }
            if(isGood(r , c+ 1, grid)){
                int[] ar = makeArray(r , c+ 1, t + 1);
                grid[r][c+1] = 2;
                q.add(ar);
            }
            if(isGood(r , c-1, grid)){
                int[] ar = makeArray(r , c-1, t + 1);
                grid[r][c-1] = 2;
                q.add(ar);
            }

        }

        // search the grid to see if we finished
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return(time);
        
    }

    public int[] makeArray(int row, int col, int time){
        int[] ans = new int[3];
        ans[0] = row;
        ans[1] = col; 
        ans[2] = time;
        return(ans); 
    }

    public boolean isGood(int row, int col, int[][] grid){
        if (row < 0 || row >= grid.length){
            return false;
        }
        if(col < 0 || col >= grid[0].length){
            return false; 
        }
        if(grid[row][col] != 1){
            return false;
        }
        return true;
    }

}
