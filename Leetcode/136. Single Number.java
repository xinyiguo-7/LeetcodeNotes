// Time Complexity: O(logN)
// Space Complexity: O(1)
// Approach:
// 1. Sort the array
// 2. Check if first element is the single one. If yes, return
// 3. Loop through the rest of the array. If found one element not equal to both adjacent ones, return
// 4. If 2nd - 2nd to last elements don't satisfy the requirement, return the last one.
class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        if(nums.length <= 1 || nums[0] != nums[1]) {
            return nums[0];
        }
        for(int i = 1; i < nums.length - 1; i++) {
            if(nums[i - 1] != nums[i] && nums[i + 1] != nums[i]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }
}