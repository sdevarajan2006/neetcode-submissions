class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // prerequisites[i] = a,b: you must take b before a 
        // put it into a hashmap and go through a deep dive? 
        java.util.HashMap<Integer,List<Integer>> prereqs = new java.util.HashMap<>();

        // put everything into the hashmap 
        for(int[] p : prerequisites){
            int a = p[0]; 
            int b = p[1]; 
            if (prereqs.containsKey(a)){
                prereqs.get(a).add(b);
            }
            else{
                java.util.List<Integer> nl = new java.util.ArrayList<>(); 
                nl.add(b);
                prereqs.put(a, nl); 
            }
        }

        for(int i = 0; i < numCourses; i++){
            Set<Integer> set = new HashSet<>();
            boolean b = helper(prereqs, set, i); 
            if(b == false){
                return false; 
            }
        }
        return true;
        


        
    }

    public boolean helper(HashMap<Integer,List<Integer>> prereqs, Set<Integer> path, int courseNum){

        // base Case: courseNum is in path: 
        if(path.contains(courseNum)){
            return false; 
        }
        if(!prereqs.containsKey(courseNum)){
            return true; 
        }

        path.add(courseNum);
        List<Integer> preqs = prereqs.get(courseNum); 
        for(int i : preqs){
            boolean a = helper(prereqs,path, i); 
            if(a == false){
                return false;
            }
            path.remove(courseNum);
        }
        return true; 
        // if courseNum is not in prereqs 
        
    }
}
