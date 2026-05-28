class PrefixTree {
    TrieNode root;



    public PrefixTree() {
        root = new TrieNode('0');
    }

    public void insert(String word) {
        int i = 0;
        char currChar;
        TrieNode pointer = root; 

        while(i < word.length()){
            currChar = word.charAt(i);
            pointer.addChild(currChar);
            pointer = pointer.getChild(currChar);
            i += 1;
        }

        pointer.setIEOW(true);
    }

    public boolean search(String word) {
        int i = 0; 
        char currChar; 
        TrieNode pointer = root; 

        while( i < word.length()){
            currChar = word.charAt(i);
            if(pointer.hasChild(currChar) == false){
                return false;
            }
            pointer = pointer.getChild(currChar);
            i += 1;
        }
        return pointer.isEndOfWord;

    }

    public boolean startsWith(String prefix) {
        int i = 0; 
        char currChar; 
        TrieNode pointer = root; 

        while( i < prefix.length()){
            currChar = prefix.charAt(i);
            if(pointer.hasChild(currChar) == false){
                return false;
            }
            pointer = pointer.getChild(currChar);
            i += 1;
        }
        return true;
        

    }
}

class TrieNode{
    char character; 
    java.util.HashMap<Character, TrieNode> children;
    boolean isEndOfWord;

    public TrieNode(char character){
        this.character = character;
        children = new java.util.HashMap<>();

    }
    public void addChild(char t){
        if (!children.containsKey(t)){
            TrieNode tn = new TrieNode(t);
            children.put(t,tn);
        }
    }

    public void removeChild(char t){
        if (children.containsKey(t)){
            children.remove(t);
        }
    }

    public void setIEOW(boolean setting){
        isEndOfWord = setting;
    }

    public boolean hasChild(char t){
        return(children.containsKey(t));
    }
    public TrieNode getChild(char t){
        return(children.get(t));
    }

}
