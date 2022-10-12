// Brute force: search the array circularly until the index(i % nums.length)
// is the same as itself or found the next greater number
// Time Complexity: O(N^2)
// Optimal: keep a min heap of array elements indexes, when found a larger
// element larger than min, put it into the result array
// Keep a monotonic stack? --> implement this
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int N = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[N];
        
        for(int i = 0; i < N; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                int prev = stack.pop();
                ans[prev] = nums[i];
            }
            stack.push(i);
        }
        // After first pass, just do it twice, so that each element is compared
        // with all of other elements in the array
        for(int i = 0; i < N; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                int prev = stack.pop();
                ans[prev] = nums[i];
            }
            // Don't push the new indexes cuz we're not dealing with them in this pass
            // stack.push(i);
        }
        // Deal with elements that haven't found a larger number
        while(!stack.isEmpty()) {
            ans[stack.pop()] = -1;
        }
        return ans;
    }
    
}

// Another cleaner approach
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int N = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[N];
        
        for(int i = 0; i < 2 * N; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i % N]) {
                int prev = stack.pop();
                ans[prev] = nums[i % N];
            }
            // The number that cannot find a greater one is already pushed to stack
            // Don't push indexes on the second pass because we don't want to
            // cover previous result
            if(i < N) {
                stack.push(i % N);
            }
        }
        // Dealing with nums cannot find next maximum all at once
        while(!stack.isEmpty()) {
            ans[stack.pop()] = -1;
        }
        return ans;
    }
    
}