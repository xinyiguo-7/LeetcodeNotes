// Approach: Dynamic Programming
// Algorithm
// Initialize an array dp with length nums.length and all elements equal to 1. 
// dp[i] represents the length of the longest increasing subsequence that ends with the element at index i.
// Iterate from i = 1 to i = nums.length - 1. 
// At each iteration, use a second for loop to iterate from j = 0 to j = i - 1 (all the elements before i). 
// For each element before i, check if that element is smaller than nums[i]. If so, set dp[i] = max(dp[i], dp[j] + 1).
// Return the max value from dp.

// Time Complexity: O(N^2)
// Space Complexity: O(N)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) { // The length of longest increasing subsequence ending at i might increase
                    dp[i] = Math.max(dp[i], dp[j] + 1);     // Length of subsequence ending at j + 1, or current length
                }
            }
        }
        
        int res = 0;
        for(int len : dp) {
            res = Math.max(res, len);
        }
        return res;
    }
}

// 11/02/2022
// Recurrence: f(i) = 1 + max(for all (j, i): f(j))
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        
        for(int i = 1; i < n; i++) {
            int max = 0;
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    max = Math.max(dp[j], max);
                }
            }
            dp[i] = max + 1;
        }
        
        int res = 0;
        for(int d : dp) {
            res = Math.max(res, d);
        }
        return res;
    }
}