// Successfule Approach: Dynamic Programming
// Case 1. The subarray takes only a middle part, and we know how to find the max subarray sum.
// Case 2. The subarray take a part of head array and a part of tail array.
//          --> Transfer this case to the first one.
//          --> The maximum array sum equals to the total sum minus the minimum subarray sum.
// Corner Case: If all numbers are negative in array A, maxSum = max(A), minSum = sum(A)

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int currentMax = 0;
        int maxSub = nums[0];
        int currentMin = 0;
        int minSub = nums[0];
        int total = 0;
        
        for(int i = 0; i < nums.length; i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            maxSub = Math.max(currentMax, maxSub);
            currentMin = Math.min(nums[i], currentMin + nums[i]);
            minSub = Math.min(currentMin, minSub);
            total += nums[i];
        }
        
        if(maxSub > 0) {
            return Math.max(maxSub, total - minSub);
        } else {
            return maxSub;
        }
    }
}


// A solution accepted in small test cases but exceeds time limit in large test cases.
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum = findMaxSum(nums, 0, nums.length - 1);
        
        for(int i = 1; i < nums.length; i++) {
            int temp = findMaxSum(nums, i, i - 1);
            maxSum = Math.max(temp, maxSum);
        }
        
        return maxSum;
    }
    
    public int findMaxSum(int[] nums, int beg, int end) {
        int currentSubarray = nums[beg];
        int maxSubarray = nums[beg];
        
        if(end < beg) {
            for(int i = beg + 1; i < nums.length; i++) {
                currentSubarray = Math.max(nums[i], 
                                           currentSubarray + nums[i]);
                maxSubarray = Math.max(currentSubarray, maxSubarray); 
            }
            for(int j = 0; j <= end; j++) {
                currentSubarray = Math.max(nums[j], currentSubarray + nums[j]);
                maxSubarray = Math.max(currentSubarray, maxSubarray); 
            }
        } else {
            for(int i = 1; i < nums.length; i++) {
                currentSubarray = Math.max(nums[i], currentSubarray + nums[i]);
                maxSubarray = Math.max(currentSubarray, maxSubarray); 
            }
        }
        
        return maxSubarray;
    }
}