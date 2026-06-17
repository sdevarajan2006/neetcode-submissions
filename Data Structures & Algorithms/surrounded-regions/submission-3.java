class Solution {
    public void solve(char[][] board) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'O'){
                    java.util.HashSet<Integer> path = new java.util.HashSet<>();
                    boolean ans = dfs(board, path , i, j); 
                    if(ans == true){
                        for(int p : path){
                            int r = p / board[0].length;
                            int c = p % board[0].length;
                            board[r][c] = 'X';
                        }
                    }
                }
            }
        }
        
        
    }

    public boolean dfs(char[][] board, HashSet<Integer> path, int i ,int j){
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return true;            // off the grid: doesn't disqualify the region
        }
        if (board[i][j] != 'O') {
            return true;            // wall: fine
        }
        int key = i * board[0].length + j;
        if (path.contains(key)) {
            return true;            // already counted
        }
        path.add(key);

        if (i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1) {
            return false;           // border 'O': region escapes, cannot be captured
        }
        
        boolean a = dfs(board, path, i + 1, j);
        boolean b = dfs(board, path, i -   1, j); 
        boolean c = dfs(board, path, i, j + 1); 
        boolean d = dfs(board, path, i, j - 1); 
        return a && b && c && d;
        
        
    }

    public boolean isGood(char[][] board, HashSet<Integer> path, int i , int j){
        if(i < 0 || i >= board.length){
            return false;
        }
        if(j < 0 || j >= board[0].length){
            return false;
        }
        int ts = (i * board[0].length) + j;
        if (path.contains(ts)){
            return false; 
        }

        if(board[i][j] == 'O'){
            return true; 
        }
        return false;

    }

    public boolean isEdge(char[][] board, int i , int j){
        if(i == 0|| i == board.length -1){
            return true;
        }
        if(j == 0 || j == board[0].length - 1){
            return true;
        }
        return false; 
        
    }
}
