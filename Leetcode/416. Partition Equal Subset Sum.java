// Approach: Recursion
// Time Complexity: O(2^n)
// Space Complexity: O(N)
class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int n : nums) {
            totalSum += n;
        }
        if(totalSum % 2 != 0)
            return false;
        int subsetSum = totalSum / 2;
        int n = nums.length;
        return dfs(n, subsetSum, nums);
    }
    
    public boolean dfs(int n, int subsetSum, int[] nums) {
        if(subsetSum == 0) {
            return true;
        }
        if(n == 0 || subsetSum < 0) {
            return false;
        }
        return dfs(n - 1, subsetSum - nums[n - 1], nums) || dfs(n - 1, subsetSum, nums);
    }
}

// Top down DP: Momoization
class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int n : nums) {
            totalSum += n;
        }
        if(totalSum % 2 != 0)
            return false;
        int subsetSum = totalSum / 2;
        int n = nums.length;
        // Boolean class contains the null type
        Boolean[][] dp = new Boolean[n + 1][subsetSum + 1];
        return dfs(n, subsetSum, nums, dp);
    }
    
    public boolean dfs(int n, int subsetSum, int[] nums, Boolean[][] dp) {
        if(subsetSum == 0) {
            return true;
        }
        if(n == 0 || subsetSum < 0) {
            return false;
        }
        // if a result is computed before, we don't have to do it again
        if(dp[n][subsetSum] != null) {
            return dp[n][subsetSum];
        }
        boolean result = dfs(n - 1, subsetSum - nums[n - 1], nums, dp) || dfs(n - 1, subsetSum, nums, dp);
        // store result in dp so that we don't have to compute again
        dp[n][subsetSum] = result;
        
        return result;
    }
}

// An optimized method using 1D array
class Solution {
    public boolean canPartition(int[] nums) {
        if (nums.length == 0)
            return false;
        int totalSum = 0;
        // find sum of all array elements
        for (int num : nums) {
            totalSum += num;
        }
        // if totalSum is odd, it cannot be partitioned into equal sum subset
        if (totalSum % 2 != 0) return false;
        int subSetSum = totalSum / 2;
        boolean dp[] = new boolean[subSetSum + 1];
        dp[0] = true;
        for (int curr : nums) {
            for (int j = subSetSum; j >= curr; j--) {
                dp[j] |= dp[j - curr];
            }
        }
        return dp[subSetSum];
    }
}