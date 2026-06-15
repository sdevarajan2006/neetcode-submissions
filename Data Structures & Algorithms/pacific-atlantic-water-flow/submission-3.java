class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        java.util.List<List<Integer>> ans = new java.util.ArrayList<>(); 
        // do a dfs from each node and store boolean[][] atlantic and boolean[][]pacific
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] visited = new boolean[heights.length][heights[0].length];

        //top row - pacific = true
        // bottom row - atlantic = true 
        for(int j = 0; j < heights[0].length; j++){
            pacific[0][j] = true;
            atlantic[heights.length - 1][j] = true;       }
        
        // leftmost column: pacific = true
        //rightmost column: atlantic = true 
        for(int i = 0; i < heights.length; i++){
            pacific[i][0] = true;
            atlantic[i][heights[0].length - 1] = true;
        }
    
        for(int i = 0; i < heights.length; i++){
            for(int j = 0; j < heights[0].length; j++){
                dfs(i, j, heights, pacific, heights[i][j], new boolean[heights.length][heights[0].length]); 
                dfs(i, j, heights, atlantic, heights[i][j], new boolean[heights.length][heights[0].length]);  
            }
        }
        
        
    

        for(int i = 0; i < heights.length; i++){
            for(int j = 0; j < heights[0].length; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    java.util.List<Integer> toAdd = new java.util.ArrayList<>(); 
                    toAdd.add(i); 
                    toAdd.add(j);
                    ans.add(toAdd);
                } 
            }
        }
        return(ans); 

        

        
    }

    public boolean dfs(int i, int j, int[][] heights, boolean[][] ocean, int oldVal, boolean[][] visited){
        // i, j, oob
        if(i < 0 || i >= heights.length){
            return false; 
        }

        if(j < 0 || j >= heights[0].length){
            return false; 
        }
        if(heights[i][j] > oldVal){
            return false;
        }
        if(ocean[i][j] == true){
            return true; 
        }

        if(visited[i][j]){
            return false;
        }

        visited[i][j] = true;

        int val = heights[i][j];

        boolean d1 = dfs(i + 1, j, heights, ocean, val, visited);
        boolean d2 = dfs(i - 1, j, heights, ocean, val, visited);
        boolean d3 = dfs(i , j + 1, heights, ocean, val, visited);
        boolean d4 = dfs(i , j - 1, heights, ocean, val, visited);

        boolean ans = ((d1 || d2) || (d3 || d4));
        ocean[i][j] = ans;
        return(ans); 

    }

    
}
