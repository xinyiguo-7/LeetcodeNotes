// Approach 1: write two method to find first and last index
// Time complexity: O(logn)
// Space complexity: O(1)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) {
            return new int[]{-1, -1};
        }
        int first = findFirst(nums, target);
        int second = findSecond(nums, target);
        return new int[]{first, second};
    }
    
    public int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int idx = -1;
        while(left <= right) {
            int mid = (left + right) / 2;
            // when the target is found at index mid,
            // save the mid index and keep finding on the left subarray
            if(target <= nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            if(target == nums[mid]) {
                idx = mid;
            }
        }
        return idx;
    }
    
    public int findSecond(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int idx = -1;
        while(left <= right) {
            int mid = (left + right) / 2;
            // when the target is found at index mid,
            // save the mid index and keep finding on the right subarray
            if(target >= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            if(target == nums[mid]) {
                idx = mid;
            }
        }
        return idx;
    }
}

// Approach 2: also binary search, but combine two functions into one by adding conditions
// Same time and space complexity

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) {
            return new int[]{-1, -1};
        }
        int first = findBounds(nums, target, true);
        // if not found, just return [-1, -1]
        if(first == -1) {
            return new int[]{-1, -1};
        }
        int last = findBounds(nums, target, false);
        return new int[]{first, last};
    }
    
    public int findBounds(int[] nums, int target, boolean findFirst) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            // when target found, justify whether it is the lower or upper bound
            if(target == nums[mid]) {
                // when found target, check if the element is the first one
                if(findFirst) {
                    if(mid == left || nums[mid - 1] != target) {
                        return mid;
                    }
                    right = mid - 1;
                } else {    // check if the element is the last one
                    if(mid == right || nums[mid + 1] != target) {
                        return mid;
                    }
                    left = mid + 1;
                }
            } else if(target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}