// Time Complexity: O(1)
// Space Complexity: O(1)
public class Solution {
    // you need to treat n as an unsigned value
    public int reverseBits(int n) {
        int x = 1;
        int y = 0;
        for(int i = 0; i < 32; i++) {
            y <<= 1;
            y += n & x;
            n >>= 1;
        }
        return y;
    }
}