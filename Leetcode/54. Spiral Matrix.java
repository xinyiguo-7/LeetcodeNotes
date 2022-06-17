// Approach: Find out the specific pattern of adding, then sum them up
// in the while loop
// Time Complexity: O(M * N)
// Space Complexity: O(1) - not including the result list
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int width = matrix[0].length;
        int height = matrix.length;
        int size = width * height;
        
        int r = 0, c = -1;
        int direction = 1;
        while(res.size() < size) {
            for(int i = 0; i < width; i++) {
                c += direction;
                res.add(matrix[r][c]);
            }
            // after adding one row, the height should be decreased by one
            height--;
            for(int j = 0; j < height; j++) {
                r += direction;
                res.add(matrix[r][c]);
            }
            // after adding one column, the width should be decreased by one           
            width--;
            direction = -direction;
        }
        return res;
    }
}

// Leetcode solution
// Same time and space complexity
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int rows = matrix.length;
        int columns = matrix[0].length;
        int up = 0;
        int left = 0;
        int right = columns - 1;
        int down = rows - 1;

        while (result.size() < rows * columns) {
            // Traverse from left to right.
            for (int col = left; col <= right; col++) {
                result.add(matrix[up][col]);
            }
            // Traverse downwards.
            for (int row = up + 1; row <= down; row++) {
                result.add(matrix[row][right]);
            }
            // Make sure we are now on a different row.
            if (up != down) {
                // Traverse from right to left.
                for (int col = right - 1; col >= left; col--) {
                    result.add(matrix[down][col]);
                }
            }
            // Make sure we are now on a different column.
            if (left != right) {
                // Traverse upwards.
                for (int row = down - 1; row > up; row--) {
                    result.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            up++;
            down--;
        }

        return result;
    }
}