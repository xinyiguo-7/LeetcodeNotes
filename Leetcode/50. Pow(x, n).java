// Time Complexity: O(logN)
// Space Complexity: O(1)
class Solution {
    public double myPow(double x, int n) {
        long N = n;
        // Reconstruct x and N
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return fastPow(x, N);
    }
    
    // multiply doubles by itself will speed up the process
    private double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}


// Approach: Brute Force
// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public double myPow(double x, int n) {
        
        double powered = 1.0;
        while(n > 0) {
            powered *= x;
            n--;
        }
        while(n < 0) {
            powered *= 1.0 / x;
            n++;
        }
    
        return powered;
    }
}
