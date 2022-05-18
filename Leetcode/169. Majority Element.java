// Time Complexity: O(logN + N) = O(N)
// Space Complexity: O(N)
// Approach: Sort the array. Keep track of the first and last occurrences of 
// each element. If times of occurrences is no less than half of the array
// length, then return.
class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        int first = 0, last = 0;
        int current = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == current) {
                last = i;
                if(last - first >= nums.length / 2) {
                    return current;
                }
            } else {
                current = nums[i];
                first = i;
                last = i;
            }
        }
        return -1;
    }
}