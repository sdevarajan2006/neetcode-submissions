class Solution {
    int[][] visited; 
    public boolean exist(char[][] board, String word) {
        visited = new int[board.length][board[0].length]; 
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                
                if (helper(board, word, 0, i, j) == true){
                    return true;
                }
            }
        }
        return false; 
        
        
    }

    public boolean helper(char[][] board, String word, int pointer, int row, int col){ 
        if(pointer >= word.length()){
            return true;
        }
        // check if row is oob 
        if (row < 0 || row >= board.length){
            return false;
        }

        // check if col is oob 
        if (col < 0 || col >= board[0].length){
            return false; 
        }
        
        // check if pointer is oob - means we found a valid soln 
        

        // check if row, col is visited 
        if(visited[row][col] == 1){ 
            return false;
        }

        // check if pointer, row, col line up 
        if(board[row][col] == (word.charAt(pointer))){
            visited[row][col] = 1;
            boolean a = helper(board, word, pointer + 1, row + 1, col);
            boolean b = helper(board, word, pointer + 1, row - 1, col);
            boolean c = helper(board, word, pointer + 1, row, col + 1);
            boolean d = helper(board, word, pointer + 1, row, col - 1);
            visited[row][col] = 0; 
            return(a || b || c || d);
            
        }
        else{
            return false;
        }

    } 
}
