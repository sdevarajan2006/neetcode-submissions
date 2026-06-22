class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length; 
        int[] parent = new int[n +1]; 


        for(int i = 1; i <= n; i ++){
            parent[i] = i; 
        }

        for(int[] edge : edges){
            int from = edge[0]; 
            int to = edge[1]; 

            int fromParent = find(parent, from); 
            int toParent = find(parent, to); 

            if(fromParent == toParent){
                return edge;
            }

            parent[toParent] = fromParent;
        }

        return new int[0]; 
       
        
        

        
    }

    public int find(int[] parent, int curr){
        while(parent[curr] != curr){
            curr = parent[curr];
        }
        return curr; 
    }

    
    

}
