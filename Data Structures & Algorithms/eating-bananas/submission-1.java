class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // iterate through piles to find the max value
        int upperBound = 0;
        for (int num: piles){
            if (num > upperBound){
                upperBound = num; 
            }

        }
        int lowerBound = 1;

        while (lowerBound < upperBound){
            int mid = (lowerBound + upperBound) /2; 
            if (possible(piles, h, mid)){
                upperBound = mid;
            }
            else{
                lowerBound = mid + 1;
            }
        }

        return lowerBound;




        
    }

    public boolean possible(int[] piles, int h, int k){
        int hCounter = 0;
        //System.out.println("k is ");
        //System.out.println(k);
        for (int num: piles){
            //System.out.println((num - 1) / k);
            hCounter += (num + k -1) / k;

            if (hCounter > h){
                return false;
            }


        }

        return(hCounter <= h);

    }
}




















