// Time Complexity: O(N)
// Space Complexity: O(1)
// Approach: Consider index-element as a hashmap, if a number i is present, then assign - sign to the element at index i
class Solution {
    public int firstMissingPositive(int[] nums) {
        // Check if 1 is present in the array, if not then 1 is the result.
        // Replace numbers we don't care: negatives, 0s, nums > n by 1s
        int n = nums.length;
        boolean onePresent = false;
        for(int i = 0; i < n; i++) {
            if(nums[i] == 1) {
                onePresent = true;
            }
            if(nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }
        // If 1 is not present, then the result is 1
        if(!onePresent)
            return 1;
        // Flip sign of elements at index == prescence numbers
        for(int j = 0; j < n; j++) {
            int index = Math.abs(nums[j]);
            if(index == n) {
                index = 0;
            }
            nums[index] = nums[index] < 0 ? nums[index] : -nums[index];
        }
        // Return the first index where element is positive(not prescent) starting from 1
        for(int k = 1; k < n; k++) {
            if(nums[k] > 0)
                return k;
        }
        // Since nums[0] has the information for n, check this for whether n is prescent
        if(nums[0] > 0) return n;
        // If not for all above cases, return n + 1
        return n + 1;
    }
}