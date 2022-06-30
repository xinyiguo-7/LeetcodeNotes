// Time Complexity: O(1)
// Space Complexity: O(1)
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int x = 1;
        int count = 0;
        for(int i = 0; i < 32 && n != 0; i++) {
            if((x & n) == 1) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }
}