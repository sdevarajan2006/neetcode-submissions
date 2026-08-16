class Solution {
    public int minimumRecolors(String blocks, int k) {
        int fp = 0; 
        int bp = 0; 
        
        java.util.ArrayList<Integer> whites = new java.util.ArrayList<>(); 

        for(int i = 0; i < blocks.length(); i++){
            if(blocks.charAt(i) == 'W'){
                whites.add(i); 
            }
        }
        int[] whiteIds = new int[whites.size()]; 
        int c = 0; 
        for(int i : whites){
            whiteIds[c] = i; 
            c += 1; 
        }

        if(whiteIds.length == 0){
            return 0; 
        }

        int min = k; 
        for(int i = 0; i < blocks.length(); i++){
            System.out.println(i); 
            int endIndex = i + k - 1; 
            if(endIndex >= blocks.length()){
                return min; 
            }
            System.out.println(endIndex); 
            while(whiteIds[fp] < i){
                fp += 1; 
            }
            if(fp > endIndex){
                return 0; 
            }

            while(bp >= 0 && bp < whiteIds.length && whiteIds[bp] < endIndex){
                bp += 1; 
            }
            if(bp == -1){
                return 0; 
            }
            
            if (bp >= whiteIds.length || whiteIds[bp] > endIndex){
                bp -= 1; 
            }
            System.out.println(fp); 
            System.out.println(bp); 
            
            min = Math.min(min, bp - fp + 1);  
            System.out.println(min); 
            System.out.println("----------");
        }

        return min; 
        
    }
}