// Idea from discussion: keep a monotone stack and solve with dp
// How to use dp to keep the numbers:
// dp is sum of current possible subarrays minimums where subarrays // contain the current element
// For all sub-arrays with minimum m, the subarrays sum is m * # of these subarrays
// Time Complexity: O(N)
// Space Complexity: O(N)
class Solution {
    public int sumSubarrayMins(int[] arr) {
        // Stack keep track of the index of min value
        Stack<Integer> monotone = new Stack<>();
        int[] dp = new int[arr.length];
        // long M = (long)(Math.pow(10, 9) + 7);
        int total = 0;
        
        for(int i = 0; i < arr.length; i++) {
            // If current elem is smaller than the top of monotone
            // stack, keep popping numbers on stack until current
            // one is max
            while(!monotone.isEmpty() && arr[monotone.peek()] > arr[i]) {
                monotone.pop();
            }
            // If current elem is the smallest since nothing's on
            // stack, put arr[i] * (i + 1) on dp
            if(monotone.isEmpty()) {
                dp[i] = arr[i] * (i + 1);
            } else {
                // If not, then dp[i] = dp[last min index of the array] + (i - last min index) * arr[i]
                dp[i] = dp[monotone.peek()] + (i - monotone.peek()) * arr[i];
            }
            total = (total + dp[i]) % 1000000007;
            monotone.push(i);
        }
        return total;
    }
    
}