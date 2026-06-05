class Solution {
    java.util.List<List<String>> ans = new java.util.ArrayList<>();
    public int n;
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        int[][] v = new int[n][n];
        List<String> ogPath = new java.util.ArrayList<>();
        helper(0, v, ogPath);
        return(ans);
        
    }
    public void helper(int row, int[][] vacancies, List<String> path){
        // we try row and col 
        // base case: row > board so we're done 
        if (row >= vacancies.length){
            ans.add(new java.util.ArrayList(path));
            return;
        }

        for(int col = 0; col< n; col ++){
            if(vacancies[row][col] == 0){
                // add this to path
                String toAdd = queenOnCol(col);
                path.add(toAdd);
                
                // update vacancies 
                updateVacancies(row, col, vacancies);
                // call helper on (n, row + 1, vacancies, path)
                helper(row + 1, vacancies, path);
                // remove from path
                path.remove(path.size() - 1);
                // undo vacancies 
                removeVacancies(row, col,vacancies);
            }
        }



    }

    public String queenOnCol(int col){
        String before = ".".repeat(col);
        String mid = "Q";
        String after = ".".repeat(n - col - 1);
        return(before + mid + after);

    }

    public void updateVacancies(int row, int col, int[][]vacancies){
        for(int i = 0; i < n; i++){
            if (vacancies[row][i] == 0){
                vacancies[row][i] = row + 1;
            }
            if (vacancies[i][col] == 0){
                vacancies[i][col] = row + 1;
            }
        }
        int i = row + 1;
        int j = col + 1;
        while((i < n && j < n) && (i >= 0 && j >= 0)){
            if(vacancies[i][j] == 0){
                vacancies[i][j] = row + 1;
            }
            i += 1;
            j += 1;
        }

        i = row + 1;
        j = col - 1;
        while((i < n && j < n) && (i >= 0 && j >= 0)){
            if(vacancies[i][j] == 0){
                vacancies[i][j] = row + 1;
            }
            i += 1;
            j -= 1;
        }

        i = row - 1;
        j = col - 1;
        while((i < n && j < n) && (i >= 0 && j >= 0)){
            if(vacancies[i][j] == 0){
                vacancies[i][j] = row + 1;
            }
            i -= 1;
            j -= 1;
        }

        i = row - 1;
        j = col + 1;
        while((i < n && j < n) && (i >= 0 && j >= 0)){
            if(vacancies[i][j] == 0){
                vacancies[i][j] = row + 1;
            }
            i -= 1;
            j += 1;
        }

        

        
        
    }

    public void removeVacancies(int row, int col, int[][]vacancies){
        for(int i = 0; i < n; i++){
            if (vacancies[row][i] == row + 1){
                vacancies[row][i] = 0;
            }
            if (vacancies[i][col] == row + 1){
                vacancies[i][col] = 0;
            }
        }

        int i = row + 1;
        int j = col + 1;
        while((i < n && j < n) && (i >= 0 && j >= 0)){
            if(vacancies[i][j] == row + 1){
                vacancies[i][j] = 0;
            }
            i += 1;
            j += 1;
        }

        i = row + 1;
        j = col - 1;
        while((i < n && j < n) && (i >= 0 && j >= 0)){
            if(vacancies[i][j] == row + 1){
                vacancies[i][j] = 0;
            }
            i += 1;
            j -= 1;
        }

        i = row - 1;
        j = col - 1;
        while((i < n && j < n) && (i >= 0 && j >= 0)){
            if(vacancies[i][j] == row + 1){
                vacancies[i][j] = 0;
            }
            i -= 1;
            j -= 1;
        }

        i = row - 1;
        j = col + 1;
        while((i < n && j < n) && (i >= 0 && j >= 0)){
            if(vacancies[i][j] == row + 1){
                vacancies[i][j] = 0;
            }
            i -= 1;
            j += 1;
        }
    }
}
