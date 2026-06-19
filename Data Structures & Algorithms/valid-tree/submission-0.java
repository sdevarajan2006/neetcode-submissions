class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1){
            return false;
        }

        // do 1 dfs traversal and see if you visited all nodes
        java.util.HashMap<Integer, List<Integer>> neighbors = new java.util.HashMap<>();
        for(int i = 0; i < n; i++){
            java.util.ArrayList<Integer> nl = new java.util.ArrayList<>(); 
            neighbors.put(i, nl);
        }
        for(int[] edge : edges){
            int from = edge[0]; 
            int to = edge[1];
            neighbors.get(from).add(to);
            neighbors.get(to).add(from);
        }
        java.util.HashSet<Integer> visited = new java.util.HashSet<>();
        dfs(0, visited, neighbors); 
        return(visited.size() == n);

        



    }

    public void dfs(int current, Set<Integer> visited, HashMap<Integer, List<Integer>> n){
        if(visited.contains(current)){
            return;
        }
        visited.add(current); 
        List<Integer> neighbors = n.get(current); 
        for(int i : neighbors){
            dfs(i, visited, n);
        }
    }
}
