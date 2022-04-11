// Approach: Greedy
// Time complexity: O(N)
// Space complexity: O(1)

// Only decide to jump when we have reached currentJumpEnd.
// And update currentJumpEnd to farthest position.
class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int currentJumpEnd = 0;
        int farthest = 0;
        
        for(int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if(i == currentJumpEnd) {
                jumps++;
                currentJumpEnd = farthest;
            }
        }
        return jumps;
    }
}

// This is a Greedy approach that make locally optimal decisions. 
// It jumps everytime when current step > nums[i].
// However this is not globally optimal.
class Solution {
    public int jump(int[] nums) {
        if(nums.length <= 1) {
            return 0;
        }
        int jump = 0;
        int step = nums[0];
        int lastIndex = nums.length - 1;
        
        for(int i = 1; i < nums.length; i++) {
            step--;
            
            if(i + step >= lastIndex) {
                return jump + 1;
            }
            if(nums[i] > step) {
                jump++;
                step = nums[i];
            }
        }
        return jump;
    }
}