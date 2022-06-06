// Time Complexity: O(N^2)
// Space Complexity: O(N)
// Approach: Dynamic Programming
// each time when nums[i] > nums[j], 3 variables needs to be updated:
// 1. length of the longest subsequence
// 2. number of subsequences ends with nums[i]
// 3. number of longest increasing subsequences
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] len = new int[nums.length];
        int[] num = new int[nums.length];
        Arrays.fill(len, 1);
        Arrays.fill(num, 1);
        int max_len = 0, res = 0;
        
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    // If current subsequence has the same length as a previous one
                    // then the number of subsequences increases
                    if(len[i] == len[j] + 1) {
                        num[i] += num[j];
                    // else if current subsequence is shorter, then updated the current length,
                    // but number of subsequences stays the same
                    } else if(len[i] < len[j] + 1){
                        len[i] = len[j] + 1;
                        num[i] = num[j];
                    }
                }
            }
            // If current length is max length, then add current num to the result number
            if(max_len == len[i]) {
                res += num[i];
            // If current length is larger then max length, then res = num[i]
            } else if(max_len < len[i]){
                max_len = len[i];
                res = num[i];
            }
        }
        return res;
    }
}
