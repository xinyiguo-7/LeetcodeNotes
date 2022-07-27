// My BFS Solution
// Time Complexity: O(N) - N is the number of spaces in grid
// Space Complexity: O(M) - M is the max number of rotten oranges
class Solution {
    private Stack<int[]> rottenStack;
    private int minutes;
    
    public int orangesRotting(int[][] grid) {
        minutes = -1;
        rottenStack = new Stack<>();
        // 1. Find rotten orange, add to stack
        if(findOrange(grid, 2)) {
            // 2. Rotten any adjacent orange, add them to stack, increase minutes. Keep doing this step until stack empty
            rottenOrange(grid);
            // 3. Find rotten orange again to verify if every orange is rotten.
            if(findOrange(grid, 1)) {
                return -1;
            }
        } else if(findOrange(grid, 1)){
            return -1;
        } else {
            return 0;
        }
        return minutes;
    }
    
    public boolean findOrange(int[][] grid, int orange) {
        int N = grid.length;
        int M = grid[0].length;
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(grid[i][j] == orange) {
                    rottenStack.push(new int[]{i, j});
                }
            }
        }
        return !rottenStack.isEmpty();
    }
    
    public void rottenOrange(int[][] grid) {
        
        while(!rottenStack.isEmpty()) {
            Stack<int[]> newStack = new Stack<>();
            while(!rottenStack.isEmpty()) {
                int[] rotOrange = rottenStack.pop();
                int r = rotOrange[0];
                int c = rotOrange[1];
                if(r - 1 >= 0 && grid[r - 1][c] == 1) {
                    grid[r - 1][c] = 2;
                    newStack.push(new int[]{r - 1, c});
                }
                if(r + 1 < grid.length && grid[r + 1][c] == 1) {
                    grid[r + 1][c] = 2;
                    newStack.push(new int[]{r + 1, c});
                }
                if(c - 1 >= 0 && grid[r][c - 1] == 1) {
                    grid[r][c - 1] = 2;
                    newStack.push(new int[]{r, c - 1});
                }
                if(c + 1 < grid[0].length && grid[r][c + 1] == 1) {
                    grid[r][c + 1] = 2;
                    newStack.push(new int[]{r, c + 1});
                }
            }
            minutes++;
            rottenStack = newStack;
        }
    }
}