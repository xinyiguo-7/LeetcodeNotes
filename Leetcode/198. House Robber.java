// Approach 1: Dynamic Programming - Tabulation
// Time complexity: O(N)
// Space complexity: O(N)

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int[] maxAmount = new int[nums.length + 1];
        // rubbing 0 house
        maxAmount[0] = 0;
        // rubbing 1 house, which is the first house
        maxAmount[1] = nums[0];
    
        for(int i = 1; i < nums.length; i++) {
            // maxAmount[i] - max amount of money rubbing (i-1)th and previous houses
            // maxAmount[i+1] - max amount of money rubbing (i-2)th and its previous + ith house
            maxAmount[i+1] = Math.max(maxAmount[i], nums[i] + maxAmount[i - 1]);
        }
        return maxAmount[nums.length];
    }
}

// Approach 1: Dynamic Programming - Optimized
// Time complexity: O(N)
// Space complexity: O(1)

// Same ideas as above. But instead of using array to store results, 
// I used two variables maxAmount1 and maxAmount2, each represents
// maxAmount[i+1] and maxAmount[i].
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int maxAmount1 = 0;
        int maxAmount2 = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            int temp = Math.max(maxAmount2, nums[i] + maxAmount1);
            maxAmount1 = maxAmount2;
            maxAmount2 = temp;
        }
        return maxAmount2;
    }
}

