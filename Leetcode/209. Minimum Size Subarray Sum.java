// Time Complexity: O(N)
// Space Complexity: O(1)
// Approach: Sliding window with two pointers.
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int length = 0, left = 0, sum = 0;
        int res = nums.length + 1;
        for(int right = 0; right < nums.length; right++) {
            // Add current element to sum
            sum += nums[right];
            length++;
            // Shrink the subarray until we get the minimum length but still add up to target
            while(sum - nums[left] >= target && left <= right) {
                sum -= nums[left];
                left++;
                length--;
            }
            // If found the subarray sum up to target, compare length with previous result
            if(sum >= target) {
                res = Math.min(res, length);
            }
        }
        return res == nums.length + 1 ? 0 : res;
    }
}