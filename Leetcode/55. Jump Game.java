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

// Updated on 05/30/2022
// Time Complexity: O(N)
// Space Complexity: O(N)

class Solution {
    public boolean canJump(int[] nums) {
        // Edge cases to consider: An array of length 1 can be reached no matter what.
        // An array with length greater than 1 but 0 at the start cannot be reached.
        if(nums.length == 1) {
            return true;
        } else if(nums[0] == 0) {
            return false;
        }
        int stepsLeft = nums[0];
        int n = nums.length;
        
        for(int i = 1; i < n; i++) {
            stepsLeft--;
            stepsLeft = Math.max(stepsLeft, nums[i]);
            if(i + stepsLeft >= n - 1) {
                return true;
            } else if(stepsLeft == 0) {
                return false;
            }
        }
        return false;
    }
}