// Time Complexity: O(S * n) - S: amount, i.e. number of iterations of first for loop  n: coins number
// Space Complexity: O(S)

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int max = amount + 1;
        Arrays.fill(dp, max);
        dp[0] = 0;
        
        // Save the number of coins to use for each amount in the cache
        for(int curr = 1; curr <= amount; curr++) {
            for(int coin : coins) {
                if(coin <= curr) {
                    // Whether use current number of coins, or use this coin to substite previous amount
                    dp[curr] = Math.min(dp[curr], dp[curr - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}