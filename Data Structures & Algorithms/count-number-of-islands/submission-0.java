class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int islands = 0;
        int[][] dirs = {
            {-1, 0},  // up
            {1, 0},   // down
            {0, -1},  // left
            {0, 1}    // right
        };
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    grid[i][j] = '0';
                    q.offer(new int[]{i, j});
                    while (!q.isEmpty()) {
                        int[] cell = q.poll();
                        for (int[] d : dirs) {
                            int x = cell[0] + d[0];
                            int y = cell[1] + d[1];
                            if (x >= 0 && y >= 0 &&
                                x < m && y < n &&
                                grid[x][y] == '1') {
                                grid[x][y] = '0';
                                q.offer(new int[]{x, y});
                            }
                        }
                    }
                }
            }
        }
        return islands;
    }
}