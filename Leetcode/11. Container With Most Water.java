// Time Complexity: O(N)
// Space Complexity: O(1)
// Approach: Two Pointers. One on the leftmost side of array, one on the rightmost side.
// Keep track of the maximum possible area(result).
// If the left bar is lower then the right, then go to the next element to find a possibly higher one.
// Same for the right bar.
class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int res = 0;
        while(left < right) {
            res = Math.max(res, (right - left) * Math.min(height[left], height[right]));
            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}

// A brute force approach for reference
// Time Complexity: O(N^2)
// Space Complexity: O(1)
public class Solution {
    public int maxArea(int[] height) {
        int maxarea = 0;
        for (int left = 0; left < height.length; left++) {
            for (int right = left + 1; right < height.length; right++) {
                int width = right - left;
                maxarea = Math.max(maxarea, Math.min(height[left], height[right]) * width);
            }
        }
        return maxarea;
    }
}