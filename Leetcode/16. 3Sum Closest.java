// Time Complexity: O(Nl^2)
// Space Complexity: O(logN) to O(N) - depending on the sorting algorithm
// Approach: two pointers
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = nums[0] + nums[1] + nums[2] - target;
        // Find all combinations of 3 integers
        for(int i = 0; i < nums.length; i++) {
            int low = i + 1, high = nums.length - 1;
            while(low < high) {
                // update current sum
                int sum = nums[i] + nums[low] + nums[high];
                // compare current distance to difference
                if(Math.abs(sum - target) < Math.abs(diff)) {
                    // if smaller, update the difference
                    diff = sum - target;
                }
                // update the index according to sum and target
                if(sum < target) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        // we want the sum, so add target to diff
        return diff + target;
    }
}