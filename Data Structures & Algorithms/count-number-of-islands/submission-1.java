class Solution {
    public int islandCounter;
    public int[][] visited;
    public int numIslands(char[][] grid) {
        visited = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(visited[i][j] == 0 && grid[i][j] == '1'){
                    islandCounter += 1;
                    dfs(i, j,grid);
                }
            }
        }
        return islandCounter;
    }
    public void dfs(int row, int col, char[][] grid){
        if(row < 0 || row >= grid.length){
            return;
        }
        if (col < 0 || col >= grid[0].length){
            return;
        }
        if(visited[row][col] == 1 || grid[row][col] == '0'){
            return;
        }

        visited[row][col] = 1; 
        dfs(row + 1, col, grid); 
        dfs(row - 1, col, grid); 
        dfs(row , col + 1, grid); 
        dfs(row , col - 1, grid); 
   }
}
