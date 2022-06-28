// Time Complexity: > O(N^2)
// Space Complexity: O(1)
class Solution {
    public int trailingZeroes(int n) {
        int x = 1;
        int zeroCount = 0;
        for(int i = 2; i <= n; i++) {
            x *= i;
            while(x % 10 == 0) {
                zeroCount++;
                x /= 10;
            }
        }
        return zeroCount;
    }
}

// By looping over each multiple of 5, from 5 up to n, and counting 
// how many factors of 5 were in each multiple of 5. We added all 
// these counts together to get our final result.
// Time Complexity: O(logN)
// Space Complexity: O(1)
class Solution {
    public int trailingZeroes(int n) {
        int zeroCount = 0;
        long currentMultiple = 5;
        while (n > 0) {
            n /= 5;
            zeroCount += n;
        }
        return zeroCount;
    }
}
