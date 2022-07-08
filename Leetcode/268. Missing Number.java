// Time Complexity: O(N)
// Space Complexity: O(N)
class Solution {
    public int missingNumber(int[] nums) {
        int N = nums.length;
        boolean[] exists = new boolean[N + 1];
        
        for(int n : nums) {
            exists[n] = true;
        }
        
        for(int i = 0; i < exists.length; i++) {
            if(!exists[i]) {
                return i;
            }
        }
        return -1;
    }
}