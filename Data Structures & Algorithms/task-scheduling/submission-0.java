class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26]; 

        for (char task: tasks){
            freq[task - 'A'] += 1;
        }

        int maxFreq = 0; 
        for(int f : freq){
            maxFreq = Math.max(f, maxFreq); 
        }
        int nmft = 0; 
        for(int f: freq){
            if (f == maxFreq){
                nmft += 1;
            }
        }
        
        int formula = ((n + 1) * (maxFreq - 1)) + nmft; 
        return Math.max(tasks.length, formula);
        




        
    }
}
