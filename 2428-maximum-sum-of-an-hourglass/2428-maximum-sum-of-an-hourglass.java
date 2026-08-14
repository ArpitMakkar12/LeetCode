class Solution {
    public int maxSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int max_sum = Integer.MIN_VALUE;

        for(int i = 0; i < n - 2; i++) {
            for(int j = 0; j < m - 2; j++) {
                int sum = grid[i][j] + grid[i][j+1] + grid[i][j+2] + grid[i+1][j+1] + grid[i+2][j] + grid[i+2][j+1] + grid[i+2][j+2];

                max_sum = Math.max(max_sum, sum);     
            }
        }

        return max_sum;
    }
}