class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // directions = up, down, left, right 
        // switch directions when : 
            //
        
        List<Integer> path = new java.util.ArrayList<>(); 

        int currRow = 0; 
        int currCol = 0; 
        int[][] visited = new int[matrix.length][matrix[0].length]; 
        String direction = "right"; 

        while (!isOOB(currRow, currCol, visited)){
            path.add(matrix[currRow][currCol]); 
            visited[currRow][currCol] = 1; 
            if(direction == "right"){
                if(isOOB(currRow, currCol + 1, visited)){
                    direction = "down"; 
                    currRow += 1; 
                }
                else{
                    currCol += 1; 
                }
            }
            else if(direction == "down"){
                if(isOOB(currRow + 1, currCol, visited)){
                    direction = "left"; 
                    currCol -= 1; 
                }
                else{
                    currRow += 1; 
                }
            }
            else if(direction == "left"){
                if(isOOB(currRow, currCol -1, visited)){
                    direction = "up"; 
                    currRow -= 1; 
                }
                else{
                    currCol -= 1; 
                }
            }
            else{
                if(isOOB(currRow -1, currCol, visited)){
                    direction= "right"; 
                    currCol += 1; 
                }
                else{
                    currRow -= 1; 
                }
            }
            
        }

        return(path); 

        
    }

    public boolean isOOB(int r, int c, int[][] visited){
        if(r >= visited.length){
            return true; 
        }
        if(c >= visited[0].length){
            return true; 
        }
        if(r < 0 || c < 0){
            return true; 
        }
        if(visited[r][c] == 1){
            return true; 
        }
        return false; 

    }
}
