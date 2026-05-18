class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        // sort the positions in descending order 
        int n = position.length;

        int[][] cars = new int[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> b[0] - a[0]); 
        

        

        double[] time = new double[cars.length];

        for(int i = 0; i < cars.length; i++){
            int[] curr = cars[i];
            int pos = curr[0];
            int sped = curr[1];

            time[i] = (double)(target - pos) / sped;

        }

        java.util.Stack<Double> ans = new java.util.Stack<>();

        for(int i = 0; i < time.length; i++){
            double currTime = time[i];
            if (ans.size() == 0){
                ans.push(currTime);
            }
            else{
                double thatTime = ans.peek();
                if (currTime <= thatTime){
                    continue;
                }
                else{
                    ans.push(currTime);
                }
            }
        }
        return(ans.size());




    }
        






}
