// Approach 1: recursion
// Time complexity: O(2^N)
// Space complexity: O(N)
class Solution {
    public int fib(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }
}

// Approach 2: Bottom-Up Approach using Tabulation(DP solution)
// Time complexity: O(N)
// Space complexity: O(N)
class Solution {
    public int fib(int n) {
        if(n <= 1) return n;
        
        int[] cache = new int[n + 1];
        //cache[0] is initialized to 0 by default?
        cache[1] = 1;
        for(int i = 2; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[n];
    }
}