// Time Complexity: O(logbN)
// Space Complexity: O(1)
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }
}

class Solution {
    public boolean isPowerOfThree(int n) {
        if(n == 1) {
            return true;
        }
        int curr = 3;
        while(curr <= n && curr % 3 == 0) {
            if(curr == n) {
                return true;
            }
            int square = curr * curr;
            if(square <= n && square > 0) {
                curr = square;
            } else {
                curr *= 3;
            }
        }
        return false;
    }
}
