class Solution {
    public int countComponents(int n, int[][] edges) {
        // set of what has been visited. 
        // do a dfs from every n 
        // keep a counter everytime we have to restart a dfs
        // return the counter 

        // put the edges into a neighbors hashmap 
        java.util.HashMap<Integer, List<Integer>> neighbors = new java.util.HashMap<>(); 
        for(int i  =0; i < n; i++){
            java.util.ArrayList<Integer> nl = new java.util.ArrayList<>(); 
            neighbors.put(i, nl);
        }


        for(int[] edge : edges){
            int from = edge[0]; 
            int to = edge[1]; 
            neighbors.get(from).add(to);
            neighbors.get(to).add(from);
            
        }

        java.util.HashSet<Integer> p = new java.util.HashSet<>(); 
        int counter = 0; 

        for(int i = 0; i < n; i++){
            if(!p.contains(i)){
                counter += 1; 
                dfs(p, i, neighbors);
            }
        }
        return(counter); 



    }

    public void dfs(Set<Integer> path, int curr, HashMap<Integer, List<Integer>> neighbors){
        if(path.contains(curr)){
            return;
        }

        path.add(curr); 
        List<Integer> ns = neighbors.get(curr); 
        for(int x : ns){
            dfs(path, x, neighbors); 
        }

    }

}
