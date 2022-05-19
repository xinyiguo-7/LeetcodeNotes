// Time Complexity: O(N)
// Space Complexity: O(1)
// Approach: One Pass. 
// Knowing there are only 0,1,2 - 3 elements, swap 0 to the front, and 2 to the back.
class Solution {
    public void sortColors(int[] nums) {
        int last0 = -1, first2 = nums.length;
        int index = 0;
        while(index < first2) {
            if(nums[index] == 0) {
                nums[index] = nums[last0 + 1];
                nums[last0 + 1] = 0;
                last0++;
                index++;
            } else if(nums[index] == 2) { 
                nums[index] = nums[first2 - 1];
                nums[first2 - 1] = 2;
                first2--;
            } else {
                index++;
            }
        }
    }
}