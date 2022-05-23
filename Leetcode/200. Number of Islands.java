// Time Complexity: O(M * N)
// Space Complexity: O(M * N)
// Approach: DFS.
class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        // loop through all the grid
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                // if found the first island, add to count
                if(grid[i][j] == '1') {
                    count++;
                    findGrid(grid, i, j);
                }
            }
        }
        return count;
    }
    
    // Use dfs to find all squares of an island
    public void findGrid(char[][] grid, int i, int j) {
        
        if(i >= 0 && j >= 0 && i < grid.length && j < grid[i].length 
           && grid[i][j] == '1') {
            // when one is found, mark it '0'
            grid[i][j] = '0';
            // loop through the squares around the current one
            findGrid(grid, i - 1, j);
            findGrid(grid, i + 1, j);
            findGrid(grid, i, j - 1);
            findGrid(grid, i, j + 1);
        }
    }
}