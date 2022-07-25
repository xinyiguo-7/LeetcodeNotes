// Time Complexity: O(N) N: The number of elements in the grid
// Space Complexity: O(N)
// Approach: Dynamic Programming. Store the minimum possible path sum
// when traversing each square on the grid.
class Solution {
    public int minPathSum(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        int[][] dp = new int[M][N];
        dp[0][0] = grid[0][0];
        
        for(int r = 0; r < M; r++) {
            for(int c = 0; c < N; c++) {
                if(r == 0) {
                    if(c == 0)
                        continue;
                    dp[r][c] = grid[r][c] + dp[r][c - 1];
                } else if (c == 0) {
                    dp[r][c] = grid[r][c] + dp[r - 1][c];
                } else {
                    dp[r][c] = grid[r][c] + Math.min(dp[r - 1][c], dp[r][c - 1]);
                }
            }
        }
        return dp[M - 1][N - 1];
    }
}