// Approach: Dynamic programming - Tabulation 
// Time complexity: O(N)
// Space complexity: O(N) (Could be optimized to O(1))

// Difference from House Robber I: first and last house adjacent to each other
// Solution: finding max amount robbed in House[0] - House[n-1]
//                                     or House[1] - House[n]
// to avoid robbing first and last houses at the same time

class Solution {
    public int rob(int[] nums) {
        if(nums.length < 1) {
            return 0;
        } else if(nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int max1 = findMax(nums, 0);
        int max2 = findMax(nums, 1);
        
        return Math.max(max1, max2);
    }
    
    public int findMax(int[] nums, int start) {
        
        int[] maxAmount = new int[nums.length];
        
        maxAmount[0] = 0;
        maxAmount[1] = nums[start];
        
        for(int i = 1; i < nums.length-1; i++) {
            maxAmount[i+1] = Math.max(maxAmount[i], maxAmount[i-1] + nums[i + start]);
        }
        
        return maxAmount[nums.length-1];
    }
}