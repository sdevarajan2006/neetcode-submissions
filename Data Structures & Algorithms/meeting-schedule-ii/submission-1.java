/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        // find the concurrency rate through the thing 
        // sort by start time 

        int n = intervals.size();
        if(n == 0){
            return 0;
        }
        int[] starts = new int[n];
        int[] ends = new int[n];

        for (int i = 0; i < n; i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int maxCount = 1; 
        int s = 0; 
        int e = 0; 

        int count = 0; 

        
        while(e < ends.length && s < starts.length){
            if(starts[s] < ends[e]){
                s += 1; 
                count += 1;
            }
            else{
                e += 1;
                count -= 1; 
            }

            maxCount = Math.max(count, maxCount); 
            
             

        }
        return(maxCount);



        
    }
}
