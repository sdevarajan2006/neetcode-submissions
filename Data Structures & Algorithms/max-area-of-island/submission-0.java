class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxSize = 0; 
        int[][] visited = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1 && visited[i][j] == 0){
                    int size = dfs(i, j, grid, visited);
                    maxSize = Math.max(size, maxSize);
                }
                
            }
        
        }
        return(maxSize);
        
    }

    public int dfs(int row, int col, int[][] grid, int[][] visited){
        if(row < 0 || row >= grid.length){
            return 0;
        }
        if(col < 0 || col >= grid[0].length){
            return 0; 
        }
        if(visited[row][col] == 1){
            return 0;
        }
        if(grid[row][col] == 0){
            return 0;
        }
        visited[row][col] = 1;
        
        int a = dfs(row + 1, col, grid, visited);
        int b = dfs(row - 1, col, grid, visited);
        int c = dfs(row, col + 1, grid, visited);
        int d = dfs(row, col -1, grid, visited);

        return(1 + a + b + c + d);

    }
        

    
}
