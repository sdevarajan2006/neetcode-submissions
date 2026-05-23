class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()){
            return "";
        }
        
        java.util.HashMap<Character, Integer> sFrequencies = new java.util.HashMap<>();
        java.util.HashMap<Character,Integer> tFrequencies = new java.util.HashMap<>(); 
        java.util.HashMap<Character,Integer> accFrequencies = new java.util.HashMap<>();

        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            tFrequencies.put(c, tFrequencies.getOrDefault(c, 0) + 1);
        }

        for(int i = 0; i < t.length(); i++){
            char c = s.charAt(i);
            if(tFrequencies.containsKey(c)){
                int valueT = tFrequencies.get(c);
                int valueS = 0; 
                if (sFrequencies.containsKey(c)){
                    valueS = sFrequencies.get(c);
                }
                if (valueS < valueT){
                    sFrequencies.put(c, sFrequencies.getOrDefault(c, 0) + 1);
                }
                accFrequencies.put(c, accFrequencies.getOrDefault(c,0) + 1);
            }
        }


        int leftAns = -1;
        int rightAns = -1;
        int minLength = Integer.MAX_VALUE;
        int left = 0; 
        int right = t.length() - 1;

        while(left < s.length() && right < s.length()){
            System.out.println(left);
            System.out.println(right);
            
            if (tFrequencies.equals(sFrequencies)){
                System.out.println("hallelujah");
                int length = right - left + 1; 
                if (length < minLength){
                    minLength = Math.min(length, minLength); 
                    leftAns = left;
                    rightAns = right;

                }
                char leftChar = s.charAt(left);
                

                accFrequencies.put(leftChar, accFrequencies.getOrDefault(leftChar, 1) -1);
                int value = accFrequencies.get(leftChar);
                
                if (sFrequencies.containsKey(leftChar)){
                    sFrequencies.put(leftChar, Math.min(value, tFrequencies.get(leftChar)));
                }
                
                left += 1;
                
                
            }
            else{
                char leftChar = s.charAt(left);
                if(tFrequencies.containsKey(leftChar)){
                    right += 1; 
                    if (right == s.length()){
                        break;
                    }
                    char rightChar = s.charAt(right);
                    accFrequencies.put(rightChar, accFrequencies.getOrDefault(rightChar, 0) + 1);
                    
                    if(tFrequencies.containsKey(rightChar)){
                        int value = tFrequencies.get(rightChar);
                        sFrequencies.put(rightChar, Math.min(accFrequencies.get(rightChar), value)); 
                    }

                }
                else{
                    left += 1;
                
                }
                

            }
            System.out.println("-----");

            }
            String ans = "";
            if (leftAns == -1){
                return ans;
            }

            for(int i = leftAns; i <= rightAns; i++){
                char c = s.charAt(i);
                ans = ans + c;

            }     
            return(ans);
            
        }
        
    }

