class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int[][] safenessFactors = getSafenessFactors(grid);
        int n = grid.size();

        int lo = 0;
        int hi = grid.size();
        int ans = -1;
        while(lo <= hi){
            boolean[][] visited = new boolean[grid.size()][grid.size()];
            int mid = (lo + hi) / 2;
            if(possible(0,0,safenessFactors, mid, visited)){
                ans = mid;
                lo = mid + 1;
            }
            else{
                hi = mid - 1;
            }
        }
        return ans;



    }

    public int[][] getSafenessFactors(List<List<Integer>> grid){
        int n = grid.size();

        // from each thief, we need to do a BFS to put in the minimum safeness factor
        int[][] ans = new int[grid.size()][grid.size()];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                ans[i][j] = n;
            }
        }
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (grid.get(i).get(j) == 1) {
                    ans[i][j] = 0;
                    q.add(new int[]{i, j});
                }

        int depth = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!q.isEmpty()) {
            int size = q.size();
            depth++;
            for (int k = 0; k < size; k++) {
                int[] cur = q.poll();
                for (int[] dir : dirs) {
                    int r = cur[0] + dir[0], c = cur[1] + dir[1];
                    if (r < 0 || r >= n || c < 0 || c >= n || ans[r][c] != n) continue;
                    ans[r][c] = depth;
                    q.add(new int[]{r, c});
                }
            }
        }

        return(ans);


    }

    public boolean inBounds(List<Integer> item, int n){
        int row = item.get(0);
        int col = item.get(1);

        if(row < 0 || row >= n){
            return false;
        }

        if(col < 0 || col >= n){
            return false;
        }
        return true;

    }

    public boolean possible(int row, int col, int[][] d, int limit, boolean[][] visited){
    if(row < 0 || row >= d.length || col < 0 || col >= d.length) return false;
    if(visited[row][col] || d[row][col] < limit) return false;
    if(row == d.length - 1 && col == d.length - 1) return true;

    visited[row][col] = true;
    return possible(row+1, col, d, limit, visited)
        || possible(row-1, col, d, limit, visited)
        || possible(row, col+1, d, limit, visited)
        || possible(row, col-1, d, limit, visited);
}
}
