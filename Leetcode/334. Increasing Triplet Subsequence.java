// Time Complexity: O(N)
// Space Complexity: O(1)
// Approach: Linear Scan
// Find the 3rd element that is greater than the previous two. Keep updating
// the first and second element with condition check.
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int num1 = Integer.MAX_VALUE, num2 = Integer.MAX_VALUE;
        
        for(int i = 0; i < nums.length; i++) {
            // Find the first smallest element
            if(nums[i] <= num1) {
                num1 = nums[i];
            // If not smaller than the first one, check if is smaller than 2nd
            } else if(nums[i] <= num2) {
                num2 = nums[i];
            // In neither of cases above, we've found the 3rd largest element. Return true.
            } else{
                return true;
            }
        }
        return false;
    }
}