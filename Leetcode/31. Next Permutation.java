// Approach: Single Pass Approach
// Time Complexity: O(N)
// Space Complexity: O(1)
// Algorithm:
// From the right, find first decreasing element A,
// go back from left to right to find an element B 
// just larger than A, (smaller than all previous ones)
// swap A and B. ----> Find lexicographically greater permutation
// Reverse array after where A was originally at. ----> Make sure the permutation is just the next one
class Solution {
    public void nextPermutation(int[] nums) {
        int N = nums.length;
        int s = 0;
        for(int i = N - 1; i > 0; i--) {
            if(nums[i] > nums[i - 1]) {
                int j = i;
                while(j < N && nums[j] > nums[i - 1]) {
                    j++;
                }
                j--;
                swap(nums, i - 1, j);
                s = i;
                break;
            }
        }
        reverse(nums, s);
    }
    
    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    
    public void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while(start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}