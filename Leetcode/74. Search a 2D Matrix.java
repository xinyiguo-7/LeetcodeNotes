// One-pass Binary Search
// Time Complexity: O(log N)
// Space Complexity: O(1)
class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            // on the basis of binary search, we need to decide
            // whether the result is in non-rotated subarray or not.
            if(target == nums[mid]) {
                return mid;
            } else {
                // Either left or right subarray is rotated
                // Left subarray is non-rotated
                //  - if target within range, go left
                //  - else, go right
                // Right subarray is non-rotated
                //  - if target within range, go right
                //  - else, go left
                if(nums[left] <= nums[mid]) {
                    if(target >= nums[left] && target <= nums[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    if(target >= nums[mid] && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
        }
        return -1;
    }
}