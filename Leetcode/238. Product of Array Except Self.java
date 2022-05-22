// Time Complexity: O(N)
// Space Complexity: O(N)
// Approach: Left and right product list.
// Update the left array by multiplying the elements in front of it, (left[i] = left[i - 1] * nums[i - 1])
// then each element would be the product of all elements on the left side of it.
// Same for the right array. By multiplying the two arrays together we'll get our result.
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] res = new int[nums.length];
        
        left[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        
        right[nums.length - 1] = 1;
        for(int j = nums.length - 2; j >= 0; j--) {
            right[j] = right[j + 1] * nums[j + 1];
        }
        
        for(int k = 0; k < nums.length; k++) {
            res[k] = left[k] * right[k];
        }
        
        return res;
    }
}