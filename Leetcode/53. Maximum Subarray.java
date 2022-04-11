// This solution doesn't work because we may lose
// the max-sum possible subarray by adding element
// left to right and subtracting left to right
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0, maxSum = 0;
        
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(sum > maxSum) {
                maxSum = sum;
            }
        }
        
        for(int j = 0; j < nums.length; j++) {
            sum -= nums[j];
            if(sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }
}

// Successful Approach 1: Dynamic Programming
// Time Complexity: O(N)
// Space Complexity: O(1)

// Key of the solution: if currentSubarray is negative, not worth keeping
// other wise it is worth keeping.
class Solution {
    public int maxSubArray(int[] nums) {
        int currentSubarray = nums[0];
        int maxSubarray = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            // If currentSubarray is negative, clear and reset.
            // A clever trick: if currentSubarray < 0 --> num < num + currentSubarray
            currentSubarray = Math.max(nums[i], currentSubarray + nums[i]);
            maxSubarray = Math.max(currentSubarray, maxSubarray);
        }

        return maxSubarray;
    }
}


// Approach 2: Divide and Conquer - from LeetCode solution. Will get back to this later
// Time complexity: O(NlogN)
// Space complexity: O(logN)

class Solution {
    private int[] numsArray;
    
    public int maxSubArray(int[] nums) {
        numsArray = nums;
        
        // Our helper function is designed to solve this problem for
        // any array - so just call it using the entire input!
        return findBestSubarray(0, numsArray.length - 1);
    }
    
    private int findBestSubarray(int left, int right) {
        // Base case - empty array.
        if (left > right) {
            return Integer.MIN_VALUE;
        }
        
        int mid = Math.floorDiv(left + right, 2);
        int curr = 0;
        int bestLeftSum = 0;
        int bestRightSum = 0;
        
        // Iterate from the middle to the beginning.
        for (int i = mid - 1; i >= left; i--) {
            curr += numsArray[i];
            bestLeftSum = Math.max(bestLeftSum, curr);
        }
        
        // Reset curr and iterate from the middle to the end.
        curr = 0;
        for (int i = mid + 1; i <= right; i++) {
            curr += numsArray[i];
            bestRightSum = Math.max(bestRightSum, curr);
        }
        
        // The bestCombinedSum uses the middle element and the best
        // possible sum from each half.
        int bestCombinedSum = numsArray[mid] + bestLeftSum + bestRightSum;
        
        // Find the best subarray possible from both halves.
        int leftHalf = findBestSubarray(left, mid - 1);
        int rightHalf = findBestSubarray(mid + 1, right);
        
        // The largest of the 3 is the answer for any given input array.
        return Math.max(bestCombinedSum, Math.max(leftHalf, rightHalf));
    }
}

