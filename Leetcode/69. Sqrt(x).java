// Time Complexity: O(logN)
// Space Complexity: O(1)
class Solution {
    public int mySqrt(int x) {
        if (x < 2) 
            return x;

        long num;
        // A fact of sqrt: it's between 2 and x/2
        int pivot, left = 2, right = x / 2;
        // int pivot, left = 1, right = x / 2;  // Also works
        while (left <= right) {
            pivot = (left + right) / 2;
            num = (long)pivot * pivot;
            if (num > x) 
                right = pivot - 1;
            else if (num < x) 
                left = pivot + 1;
            else 
                return pivot;
        }

        return right;
    }
  }