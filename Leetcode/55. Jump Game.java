
// My Approach: Dynamic Programming - Tabulation
// Time Complexity: O(N)
// Space Complexity: O(N)

// Use a boolean array to store status for each array position
// while looping through the array, update steps remaining and status array
// return status of the last array element

class Solution {
    public boolean canJump(int[] nums) {
        boolean[] reached = new boolean[nums.length];
        int step = nums[0], index = 0;
        reached[0] = true;
        
        while(step >= 0 && index < nums.length) {
            // change position status
            reached[index] = true;
            // if current step is greater than remaining one, update
            step = Math.max(step, nums[index]);
            
            step--;
            index++;
        }
        return reached[nums.length - 1];
    }
}