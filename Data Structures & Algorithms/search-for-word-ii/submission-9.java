class Solution {
    // mark visited
    int[][] visited;
    List<String> ans  = new java.util.ArrayList<>();
    char[][] board;
    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        PrefixTree pt = new PrefixTree(); 
        for (String word : words){
            pt.insertString(word);
        }
        int m = board.length;
        int n = board[0].length;
        visited = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dfs(i,j,pt.root);
            }
        }

        return(ans);



        
    }

    public void dfs(int row, int col, TrieNode curr){
        if(row >= visited.length || row < 0){
            return;
        }
        if (col >= visited[0].length || col < 0){
            return;
        }
        if(curr == null){
            return;
        }
        if(visited[row][col] == 1){
            return;
        }

        char c = board[row][col];
        if (!curr.hasChild(c)){
            return;
        }

        TrieNode next = curr.getChild(c);
        if (next.word != null){
            ans.add(next.word);
            next.word = null;
        }

        visited[row][col] = 1;

        dfs(row + 1, col, next);
        dfs(row - 1, col, next);
        dfs(row, col + 1, next);
        dfs(row, col - 1, next);

        visited[row][col] = 0;

    }
}

class PrefixTree{
    TrieNode root; 

    public PrefixTree(){
        root = new TrieNode('0');
    }

    public void insertString(String word){
        int i = 0; 
        char currChar; 
        TrieNode pointer = root; 

        while(i < word.length()){
            currChar = word.charAt(i);
            pointer.addChild(currChar);
            pointer = pointer.getChild(currChar);
            i += 1;
        }
        pointer.setWord(word);
    }
    
}

class TrieNode{ 
    char character;
    java.util.HashMap<Character, TrieNode> children; 
    String word; 

    public TrieNode(char character){
        this.character = character; 
        children = new java.util.HashMap<>();
    }

    public void addChild(char t){
        if(!children.containsKey(t)){
            TrieNode newTn = new TrieNode(t);
            children.put(t,newTn);
        }
    }

    public void removeChild(char t){
        if(children.containsKey(t)){
            children.remove(t);
        }
    }

    public void setWord(String setting){
        this.word = setting;
    }

    public boolean hasChild(char t){
        return(children.containsKey(t));
    }

    public TrieNode getChild(char t){
        if (hasChild(t)){
            return(children.get(t));
        }
        return null;
    }
}



