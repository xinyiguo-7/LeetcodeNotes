// Time Complexity: O(NlogN)
// Space Complexity: O(logN) - space complexity needed for quicksort implemented by Java
class Solution {
    public int smallestRangeII(int[] nums, int k) {
        int N = nums.length;
        Arrays.sort(nums);
        int diff = nums[N - 1] - nums[0];
        
        for(int i = 0; i < N - 1; i++) {
            int high = Math.max(nums[i] + k, nums[N - 1] - k);
            int low = Math.min(nums[i + 1] - k, nums[0] + k);
            diff = Math.min(diff, high - low);
        }
        return diff;
    }
}