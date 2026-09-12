class Solution {

    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    q.add(new int[]{i, j, 0});
                }
            }
        }

        boolean[][] visited = new boolean[n][m];

        while(q.size() > 0) {
            int[] curr = q.poll();
            int i = curr[0];
            int j = curr[1];
            int time = curr[2];

            ans = Math.max(ans, time);

            if(i - 1 >= 0 && !visited[i - 1][j] && grid[i - 1][j] == 1) {  //top
                q.add(new int[]{i - 1, j, time + 1});
                visited[i - 1][j] = true;
            } 
            
            if(j + 1 < m && !visited[i][j + 1] && grid[i][j + 1] == 1) {  //right
                q.add(new int[]{i, j + 1, time + 1});
                visited[i][j + 1] = true;
            }  

            if(i + 1 < n && !visited[i + 1][j] && grid[i + 1][j] == 1) {  //bottom
                q.add(new int[]{i + 1, j, time + 1});
                visited[i + 1][j] = true;
            }

            if(j - 1 >= 0 && !visited[i][j - 1] && grid[i][j - 1] == 1) {  //left
                q.add(new int[]{i, j - 1, time + 1});
                visited[i][j - 1] = true;
            }
        }

        // check for fresh oranges
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    return -1;
                }
            }
        }

        return ans;
    }
}