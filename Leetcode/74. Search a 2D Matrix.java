// Time Complexity: O(N^2)
// Space Complexity: O(1)
// Approach: Just compare the first and last element to target to see if
// it is in this row. If yes, then run binary search on this row.
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] <= target 
               && matrix[i][matrix[i].length - 1] >= target) {
                if(binarySearch(matrix[i], target) != -1) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
    
    public int binarySearch(int[] row, int target) {
        int left = 0, right = row.length - 1;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            if(row[mid] == target) {
                return mid;
            } else if(row[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}