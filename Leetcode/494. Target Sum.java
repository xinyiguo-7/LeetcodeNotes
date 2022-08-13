// Brute Force: backtracking
// Time Complexity: O(2^N)

class Solution {
    int res;
    
    public int findTargetSumWays(int[] nums, int target) {
        backtrack(nums, target, 0, 0);
        return res;
    }
    
    public void backtrack(int[] nums, int target, int i, int sum) {
        if(i == nums.length) {
            if(sum == target) {
                res++;
            }
            return;
        } else {
            backtrack(nums, target, i + 1, sum + nums[i]);
            backtrack(nums, target, i + 1, sum - nums[i]);
        }
    }
}

// DP using 2D array
// Time Complexity: O(N * T)
// Space Complexity: O(N * T)
// Use a 2D array to store possible number of assignments
// horizontal direction is the nums[i] counted
// vertical direction is +nums[i] to -nums[i] from an offset total
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0, N = nums.length;
        for(int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        int[][] dp = new int[nums.length][total * 2 + 1];   // Going up or down plus the offset
        dp[0][total - nums[0]] = 1;
        dp[0][total + nums[0]] += 1;
        
        for(int i = 1; i < N; i++) {
            for(int sum = -total; sum <= total; sum++) {
                // check if previous combination exists
                // else risking the index out of bounds error
                if (dp[i - 1][sum + total] > 0) {
                    dp[i][sum + nums[i] + total] += dp[i - 1][sum + total];
                    dp[i][sum - nums[i] + total] += dp[i - 1][sum + total];
                }
            }
        }
        // dealing with the edge case that the target is greater or smaller than applying all '+' or all '-'
        return Math.abs(target) > total? 0 : dp[N - 1][target + total];
    }
}