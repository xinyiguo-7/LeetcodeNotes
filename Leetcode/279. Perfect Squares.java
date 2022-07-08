// Time Complexity: O(NlogN)
// Space Complexity: O(N)
// Approach: Dynamic programming, adapted from 322. Coin change
class Solution {
    public int numSquares(int n) {
        int squareSize = 1;
        for(int i = 1; i <= n; i++) {
            if(i * i > n) {
                squareSize = i - 1;
                break;
            }
        }
        int[] squares = new int[squareSize];
        for(int j = 0; j < squareSize; j++) {
            squares[j] = (j + 1) * (j + 1);
        }
        
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        for(int k = 1; k <= n; k++) {
            for(int sq : squares) {
                if(sq <= k) {
                    dp[k] = Math.min(dp[k], dp[k - sq] + 1);
                }
            }
        }
        return dp[n];
    }
}