// A solution that looks like DP but still rely on math
class Solution {
    public int integerBreak(int n) {
        if(n > 3) {
            n = n + 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] * j);
            }
        }
        return dp[n];
    }
}

// Approach: Dynamic Programming
// Time Complexity: O(N ^ 2)
// Space Complexity: O(N)
class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                // Divide number i into 2 factors, either factor them or don't factor them
                // Pick the larger one between the two: j and dp[j], i - j and dp[i - j]
                // dp[i] will take the largest possible product
                int factor1 = Math.max(j, dp[j]);
                int factor2 = Math.max(i - j, dp[i - j]);
                dp[i] = Math.max(dp[i], factor1 * factor2);
            }
        }
        return dp[n];
    }
}

