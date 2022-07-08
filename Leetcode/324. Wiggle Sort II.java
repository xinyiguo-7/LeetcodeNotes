// Time Complexity: O(NlogN)
// Space Complexity: O(N)
// Approach: reverse and merge the first and second half of the array
class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int N = nums.length;
        int[] res = new int[N];
        
        int first = (N - 1) / 2;
        int second = N - 1;

        for(int i = 0; i < N; i++) {
            res[i] = nums[first--];
            i++;
            if(i < N) {
                res[i] = nums[second--];
            }
        }
        System.arraycopy(res, 0, nums, 0, N);
    }
}