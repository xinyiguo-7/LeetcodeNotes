// Time Complexity: O(N)
// Space Complexity: O(1)
// Approach: Sliding Window
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        int prod = 1;
        int left = 0;
        for(int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while(prod >= k && left <= right) {
                prod /= nums[left];
                left++;
            }
            // Hard to think of: the number of new subarrays is right - left + 1
            count += right - left + 1;
        }
        return count;
    }
}