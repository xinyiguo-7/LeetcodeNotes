// Solution: Binary Search
// Time Complexity: O(logN)
// Space Complexity: O(1)

class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 2) {
            return Math.min(nums[0], nums[1]);
        } else if(nums.length == 1) {
            return nums[0];
        }
        
        int left = 0, right = nums.length-1;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            // if found the minimum on mid(both left and right subarrays not rotated)
            //      -> return mid element
            // if left-subarray is rotated
            //      -> min in left subarray-> go left(but keep mid element since it could be the pivot point)
            // if left-subarray not rotated -> right subarray rotated
            //      -> go right(excluding mid since it won't be pivot knowing nums[left] <= nums[mid])
            if(nums[left] <= nums[mid] && nums[right] >= nums[mid]) {
                return nums[left];
            } else if(nums[left] > nums[mid]) {
                right = mid;
            } else if(nums[right] < nums[mid]) {
                left = mid + 1;
            }
            // when writing the conditional statement, make sure to include all possible cases
        }
        return -1;
    }
}