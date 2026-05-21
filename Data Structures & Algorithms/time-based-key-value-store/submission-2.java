class TimeMap {
    public java.util.HashMap<String, List<Pair>> hm;

    public TimeMap() {
        hm = new java.util.HashMap<String, List<Pair>>();

        
    }
    
    public void set(String key, String value, int timestamp) {
        Pair toAdd = new Pair(timestamp, value);
        if(hm.containsKey(key)){
            hm.get(key).add(toAdd);
        }
        else{ 
            List<Pair> nl = new java.util.ArrayList<>();
            nl.add(toAdd);
            hm.put(key, nl);
        }
        
    }
    
    public String get(String key, int timestamp) {
        if (!hm.containsKey(key)){
            return "";
        }
        List<Pair> toSearch = hm.get(key);
        
        int left = 0; 
        int right = toSearch.size() - 1;

        int maxFeasibleTs = -1;
        String bestVal = "";

        while (left <= right){
            System.out.println(left);
            System.out.println(right);
            int mid = (right + left) / 2; 
            Pair midPair = toSearch.get(mid); 
            
            int midNum = midPair.getNum();
            String midString = midPair.getStr();

            if (midNum > timestamp){
                right = mid -1; 
            }
            else if (midNum < timestamp){
                if (midNum > maxFeasibleTs){
                    maxFeasibleTs = midNum;
                    bestVal = midString;
                }
                left = mid + 1;
            }
            else{ 
                // they're equal
                return(midString);
            }



        }
        return(bestVal);



        
    }

    
}

class Pair{
    public String text; 
    public int num; 
    public Pair(int n, String t){
        this.text = t;
        this.num = n;
    }
    public String getStr(){
        return text;
    }
    public int getNum(){
        return num;
    }
}
