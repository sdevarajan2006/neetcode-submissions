/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    java.util.HashMap<Integer, Node> visited = new java.util.HashMap<>(); 
    public Node cloneGraph(Node node) {
        return (dfs(node));
        
    }

    public Node dfs(Node node){
        if(node == null){
            return null;
        }
        if(visited.containsKey(node.val)){
            return(visited.get(node.val));
        }
        
        Node newNode = new Node(node.val);
        visited.put(node.val, newNode);
        java.util.ArrayList<Node> neighborsList = new java.util.ArrayList<>(); 
        for(Node n : node.neighbors){
            Node nn = dfs(n); 
            neighborsList.add(nn);
        }
        newNode.neighbors = neighborsList;
        return(newNode);
    }
}