// Approach 1: Linear Scan + Iterative Binary Search
// If (i + 1)th num is larger than (i)th, then there has
// to be a peak on the right. We use binary search to
// find the peak and narrow down to left == right.
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            if(left == right) {
                return left;
            }
            if(nums[mid + 1] > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return -1;
    }
}

// My approach that doesn't work. Too many conditions applied 
// and cannot catch all edge cases.
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 2) {
            return nums[0] > nums[1] ? 0 : 1;
        } else if(nums.length == 1) {
            return 0;
        }
        
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            
            if((mid == 0 && nums[mid] > nums[mid + 1] )
                || (mid == nums.length - 1 && nums[mid] > nums[mid - 1])
               || nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if(Math.abs(nums[mid] - nums[left]) < (mid - left) 
                      || nums[left] > nums[right]) {
                right = mid;
            } else if(Math.abs(nums[mid] - nums[right]) < (right - mid) 
                      || nums[right] > nums[left]) {
                left = mid + 1;
            } 
        }
        return -1;
    }
}