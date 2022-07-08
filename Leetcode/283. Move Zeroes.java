// Approach: Linear Scan - Swapping non-zero elements to the front
// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public void moveZeroes(int[] nums) {
        int lastIdx = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                if(lastIdx < i) {
                    nums[lastIdx] = nums[i];
                    nums[i] = 0;
                }
                lastIdx++;
            }
        }
    }
}