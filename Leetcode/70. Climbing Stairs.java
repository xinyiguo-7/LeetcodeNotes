// Approach similar to 509.Fibonacci Number

class Solution {
    public int climbStairs(int n) {
        if(n < 0) {
            return 0;
        }
        if(n == 0) {
            return 1;
        }
        int[] cache = new int[n + 1];
        cache[0] = 1;
        cache[1] = 1;
        for(int i = 2; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[n];
    }
}

// 10/11/2022
// Recursive approach

class Solution {
    public int climbStairs(int n) {
        return helper(0, n);
    }
    
    public int helper(int i, int n) {
        if(i > n) {
            return 0;
        }
        if(i == n) {
            return 1;
        }
        return helper(i + 1, n) + helper(i + 2, n);
    }
}

class Solution {
    public int climbStairs(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        int[] cache = new int[n + 1];
        // When initializing, think about the base case:
        // n = 2, 2 ways: 1 + 1 and 2
        cache[0] = 1;
        cache[1] = 1;
        for(int i = 2; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[n];
    }
}