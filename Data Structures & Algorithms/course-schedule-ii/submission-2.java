class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // put the prerequisites into a hashmap 
        java.util.HashMap<Integer, List<Integer>> preqs = new java.util.HashMap<>(); 
        for(int[] p : prerequisites){
            if(preqs.containsKey(p[0])){
                preqs.get(p[0]).add(p[1]); 
            }
            else{
                java.util.ArrayList<Integer> nl = new java.util.ArrayList<>(); 
                nl.add(p[1]);
                preqs.put(p[0], nl); 
            }
        }

        List<Integer> pathDone = new ArrayList<>();
        Set<Integer> toComplete = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            if (!helper(numCourses,preqs, pathDone, i, toComplete)) {
                return new int[0];
            }
        }

        int[] ans = new int[numCourses];
        for (int i = 0; i < numCourses; i++) ans[i] = pathDone.get(i);
        return ans;



    }

    public int[] arrayListToArray(List<Integer> aL, int numCourses){
        int[] ans = new int[numCourses]; 
        int c = 0; 
        for(int i : aL){
            ans[c] = i; 
            c += 1; 

        }

        for(int i = 0; i < numCourses; i++){
            if(!aL.contains(i)){
                ans[c] = i; 
                c += 1;
            }
        }
        return (ans);
    }

    public boolean helper(int numCourses, HashMap<Integer, List<Integer>> preqs, List<Integer> pathDone, int course, Set<Integer> toComplete){
        if(pathDone.size() == numCourses){
            return true; 
        }

        if(pathDone.contains(course)){
            return true; 
        }

        if(toComplete.contains(course)){
            return false; 
        }

        if(!preqs.containsKey(course)){
            pathDone.add(course);
            return true; 
        }

        toComplete.add(course); 
        List<Integer> cs = preqs.get(course); 

        for(int c: cs){
            boolean ans = helper(numCourses, preqs, pathDone, c, toComplete); 
            if(ans == false){
                return false;
            }
        }
        toComplete.remove(Integer.valueOf(course)); 
        pathDone.add(course); 
        return true; 

    }
}
