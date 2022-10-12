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


// 10/11/2022 - Recursive solution
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount < 1) {
            return 0;
        }
        return helper(coins, amount, new int[amount]);
    }
    
    public int helper(int[] coins, int remain, int[] memo) {
        if(remain == 0) {
            return 0;
        }
        if(remain < 0) {
            return -1;
        }
        if(memo[remain - 1] != 0) {
            return memo[remain - 1];
        }
        int min = Integer.MAX_VALUE;
        for(int coin : coins) {
            int res = helper(coins, remain - coin, memo);
            if(res >= 0 && res < min) {
                min = res + 1;
            }
        }
        memo[remain - 1] = min == Integer.MAX_VALUE ? -1 : min;
        return memo[remain - 1];
    }
}

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount < 1) {
            return 0;
        }
        int[] memo = new int[amount + 1];
        // Filling the array with MAX_VALUE will get overflow by adding 1
        // so fill with an impossible number such as amount + 1
        Arrays.fill(memo, amount + 1);
        memo[0] = 0;
        for(int i = 1; i <= amount; i++) {
            for(int coin : coins) {
                if(coin <= i) {
                    memo[i] = Math.min(memo[i - coin] + 1, memo[i]);
                }
            }
        }
        return memo[amount] > amount ? -1 : memo[amount];
    }
}