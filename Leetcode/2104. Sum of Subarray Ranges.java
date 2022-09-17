// Brute force
// Time Complexity: O(n^2)
class Solution {
    public long subArrayRanges(int[] nums) {
        long max = Integer.MIN_VALUE;
        long min = Integer.MAX_VALUE;
        long result = 0;
        
        //the last value of the array will just be zero anyway
        for(int i = 0; i < nums.length -1; i++) {
           int startVal = nums[i]; 
            for(int k = i; k < nums.length; k++) {
                int curr = nums[k];
                if(curr > max) {
                    max = curr;
                }
                if(curr < min) {
                    min = curr;
                }
                result = result + (max - min);
                
            }
            //reset max and mins
            max = nums[i+1];
            min = nums[i+1];  
        }
        return result;
    }

}

// Use dp + monotonic stack
// Remember to cast computational numbers to long to avoid large number precision error
class Solution {
    public long subArrayRanges(int[] nums) {
        // First find the subarray minimum sum
        // Then find the subarray maximum sum
        // Use the maximum - minimum
        long subMinSum = 0;
        // Use dp to keep track of the minimum subarray sum for current element
        long[] minDP = new long[nums.length];
        Deque<Integer> minStack = new LinkedList<>();
        
        for(int i = 0; i < nums.length; i++) {
            while(!minStack.isEmpty() && nums[minStack.peek()] > nums[i]) {
                minStack.pop();
            }
            if(minStack.isEmpty()) {
                minDP[i] = (long)nums[i] * (i + 1);
            } else {
                minDP[i] = (long)nums[i] * (i - minStack.peek()) + minDP[minStack.peek()];
            }
            subMinSum += minDP[i];
            minStack.push(i);
        }
        
        long subMaxSum = 0;
        // Use dp to keep track of the maximum subarray sum for current element
        long[] maxDP = new long[nums.length];
        Deque<Integer> maxStack = new LinkedList<>();
        
        for(int i = 0; i < nums.length; i++) {
            while(!maxStack.isEmpty() && nums[maxStack.peek()] < nums[i]) {
                maxStack.pop();
            }
            if(maxStack.isEmpty()) {
                maxDP[i] = (long)nums[i] * (i + 1);
            } else {
                maxDP[i] = (long)nums[i] * (i - maxStack.peek()) + maxDP[maxStack.peek()];
            }
            subMaxSum += maxDP[i];
            maxStack.push(i);
        }
        
        return subMaxSum - subMinSum;
    }
}