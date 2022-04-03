// Approach 1: Performance Optimisation : Dynamic Programming
// Time complexity : O(1) to retrieve preliminary computed Tribonacci number, 
// and 38 operations for the preliminary computations.
// Space complexity : constant space to keep an array of 38 Tribonacci numbers.

// Not sure why it is 38 though (Should be n if there are n numbers)

// precompute all the tribonacci numbers
class Solution {
    public int tribonacci(int n) {
        if(n <= 1) return n;
        int[] cache = new int[n + 1];
        cache[1] = 1;
        cache[2] = 1;
        for(int i = 3; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2] + cache[i - 3];
        }
        return cache[n];
    }
}

// Approach 2: Space Optimisation : Dynamic Programming
// instead of saving the entire array up til n, we only save 3 integers x, y, z
class Solution {
    public int tribonacci(int n) {
        if(n <= 2) return n == 0 ? 0 : 1;
        int x = 0, y = 1, z = 1;
        for(int i = 3; i <= n; i++) {
            int temp = x + y + z;
            x = y;
            y = z;
            z = temp;
        }
        return z;
    }
}
