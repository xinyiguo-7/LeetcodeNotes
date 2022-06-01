// Time Complexity: O(N * M)
// Space Complexity: O(N * M)
// Approach: Dynamic Programming
// Initialize the 2D array to be 1
// Loop through the table to add the number of paths: numPaths[i][j] = numPaths[i - 1][j] + numPaths[i][j - 1]
// Return the number on bottom right corner
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] numPaths = new int[m][n];
        for(int[] row : numPaths) {
            Arrays.fill(row, 1);
        }
        
        for(int i = 1; i < numPaths.length; i++) {
            for(int j = 1; j < numPaths[0].length; j++) {
                numPaths[i][j] = numPaths[i - 1][j] + numPaths[i][j - 1];
            }
        }
        return numPaths[m - 1][n - 1];
    }
}