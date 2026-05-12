class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        # check each row:
        for row in board: 
            for i in range(1,10):
                freq = row.count(str(i))
                if freq > 1:
                    return False 
        
        #check each column 
        for i in range(9):
            column = [row[i] for row in board]
            for x in range(1,10):
                freq = column.count(str(x))
                if freq > 1:
                    return False 
        
        #check each sub 3x3 board 
        for i in range(3):
            for j in range(3):
                relavant_rows = board[j*3: ((j + 1) * 3)]
                sub = [r[i*3 : ((i + 1) * 3)] for r in relavant_rows]
                flat = [item for sublist in sub for item in sublist]
                for x in range(1,10):
                    freq = flat.count(str(x))
                    if freq > 1:
                        return False 
        
        return True 


        