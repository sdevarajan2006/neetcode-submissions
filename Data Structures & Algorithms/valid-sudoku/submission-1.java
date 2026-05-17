class Solution {
    public boolean isValidSudoku(char[][] board) {
        // check every row 
        java.util.HashMap<Character, Integer> frequencies = new java.util.HashMap<>();

        for(char[] r: board){
            frequencies = new java.util.HashMap<>();
            for(char c: r){
                if (!(c == '.')){
                    if (frequencies.containsKey(c)){
                        System.out.println(c);
                        return false;
                        
                    }
                    else{
                        frequencies.put(c, 1);
                    }
                }
            }

        }

        // check every column 

        for (int column = 0; column < 9; column++){
            frequencies = new java.util.HashMap<>();
            for(int row = 0; row < 9; row ++){
                char c = board[row][column];
                if (!(c == '.')){
                    if (frequencies.containsKey(c)){
                        System.out.println("2");
                        return false;
                    }
                    else{
                        frequencies.put(c, 1);
                    }
                }

            }
        }

        // check every 3x3 square 
        for(int row = 0; row < 3; row++){
            for(int column = 0; column < 3; column ++){
                frequencies = new java.util.HashMap<>();
                for(int i = row * 3; i < (row * 3) + 3; i++){
                    for(int j = column * 3; j< (column * 3) +3; j++){
                        char c = board[i][j];
                        if (!(c == '.')){
                        if (frequencies.containsKey(c)){
                            System.out.println("3");
                            return false;
                        }
                        else{
                            frequencies.put(c, 1);
                        }
                        }
                    }
                }
            }
        }

        return true;


        
    }
}
