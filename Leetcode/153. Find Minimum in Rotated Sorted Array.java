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

// Second trial on 05/18/2022
class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 2) {
            return Math.min(nums[0], nums[1]);
        } else if(nums.length == 1) {
            return nums[0];
        } else if(nums.length == 0) {
            return -1;
        }
        // General case: length of array >= 3
        // Found min when 1. nums[i] < nums[i + 1] and nums[i - 1] > nums[i]
        // 2. Min is the last element when nums[0] > nums[nums.length - 1] 
        // && nums[nums.length - 1] < nums[nums.length - 2]
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[left] <= nums[mid] && nums[mid] <= nums[right]) {
                return nums[left];
            } else if(nums[left] > nums[mid]) { // left subarray is rotated
                right = mid; // in case the minimum element is at the end of left subarray
            } else{
                left = mid + 1; // the min we're trying to find can not be at mid
            }
        }
        return -1;
    }
}