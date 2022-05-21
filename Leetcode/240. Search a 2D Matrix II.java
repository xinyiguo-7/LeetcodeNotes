// Time Complexity: O(NlogN)
// Space Complexity: O(N)
// Approach: Loop through each row of matrix, check if target is within the range 
// of each row. If yes, then run binary search on that row.
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int[] row : matrix) {
            if(row[0] <= target && row[row.length - 1] >= target) {
                if(binarySearch(row, target)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean binarySearch(int[] row, int target) {
        int left = 0, right = row.length - 1;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            if(row[mid] == target) {
                return true;
            } else if (row[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}