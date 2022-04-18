// Approach: Dynamic Programming
// Time complexity: O(N)
// Space complexity: O(1)

// Using a similar solution with #918
// The tricky part is dealing with negative signs(multiplying a negative number can turn
// the max num to min or min num to max).
// Solution: compare currentNum, currentNum * maxSub and currentNum * minSub
class Solution {
    public int maxProduct(int[] nums) {
        int maxSub = nums[0];
        int minSub = nums[0];
        int result = maxSub;
        
        for(int i = 1; i < nums.length; i++) {
            int tempMax = maxSub;
            maxSub = Math.max(nums[i], Math.max(nums[i] * maxSub, nums[i] * minSub));
            minSub = Math.min(nums[i], Math.min(nums[i] * minSub, nums[i] * tempMax));
            // Also remember to save the result so that we don't lose it when updating maxSub
            result = Math.max(result, maxSub);
        }
        
        return result;
    }
}