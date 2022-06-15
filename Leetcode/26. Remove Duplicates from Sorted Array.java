// Time Complexity: O(N)
// Space Complexity: O(N)
// Approach: Two pointers
class Solution {
    public int removeDuplicates(int[] nums) {
        int currIdx = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i - 1]) {
                nums[currIdx++] = nums[i];
            }
        }
        return currIdx++;
    }
}