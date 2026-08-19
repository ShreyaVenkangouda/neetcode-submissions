class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        int min = 0;
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!q.isEmpty() && fresh > 0){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] curr = q.poll();
                int row = curr[0];
                int col = curr[1];
                for(int[] dir : dirs){
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    if(newRow >=0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 1){
                        grid[newRow][newCol] = 2;
                        fresh--;
                        q.add(new int[]{newRow,newCol});
                    }
                }
            }
            min++;
        }
        if(fresh > 0){
            return -1;
        }
        return min;
    }
}
