class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode('0');

    }

    public void addWord(String word) {
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
    public boolean search(String word){
        return(helper(word, root, 0));
    }


    public boolean helper(String word, TrieNode currroot, int p) {
        int i = p; 
        TrieNode pointer = currroot; 

        while (i < word.length()){
            char currChar = word.charAt(i);
            if (currChar == '.'){
                java.util.HashMap<Character, TrieNode> pointerChildren = pointer.children;
                for (char child : pointerChildren.keySet()){
                    TrieNode childNode = pointerChildren.get(child);
                    boolean res = helper(word, childNode, i + 1);
                    if (res == true){
                        return true;
                    }
                }
                return false;
                
            }
            if(!pointer.hasChild(currChar)){
                return false;
            }
            pointer = pointer.getChild(currChar);
            i += 1;

    }
        return pointer.isEndOfWord; 
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



