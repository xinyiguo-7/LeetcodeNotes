// Time Complexity: O(N)
// Space Complexity: O(N)
// Approach: Dynamic Programming
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length < 3) {
            return 0;
        }
        int sum = 0;
        int[] dp = new int[nums.length];
        
        // Use dp[i] to store number of possible arithmetic slices within range (k, i), where k is the minimum index
        // possible that nums[k, i] constitutes an arithmetic slice
        for(int i = 2; i < nums.length; i++) {
            if(nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                sum += dp[i];
            }
        }
        return sum;
    }
}