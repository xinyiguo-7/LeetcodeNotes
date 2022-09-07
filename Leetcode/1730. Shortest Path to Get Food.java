// Time Complexity: O(MN)
// Space Complexity: O(1)
// Approach: Basic BFS
class Solution {
    int[][] directions;
    public int getFood(char[][] grid) {
        directions = new int[][]{{1, 0},{-1, 0},{0, 1},{0, -1}};
        Queue<int[]> q = new LinkedList<>();
        int N = grid.length;
        int M = grid[0].length;
        // Find the starting point of path
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(grid[i][j] == '*') {
                    // mark visited cell as X to avoid revisit and save space
                    grid[i][j] = 'X';
                    // add as (x, y)
                    q.add(new int[]{j, i});
                    break;
                }
            }
        }
        // len is the depth of BFS
        int len = 0;
        while(!q.isEmpty()) {
            // record size for cells in this level of search
            int size = q.size();
            while(size > 0) {
                size--;
                int[] curr = q.poll();
                int x = curr[0];
                int y = curr[1];
                for(int[] d : directions) {
                    // Assume move to one of the directions
                    int newX = x + d[0];
                    int newY = y + d[1];
                    if(newX >= 0 && newX < M && newY >= 0 && newY < N
                        && grid[newY][newX] != 'X') {
                        // row is Y axis, col is X axis
                        if(grid[newY][newX] == '#') {
                            return len + 1;
                        }
                        q.add(new int[]{newX, newY});
                        grid[newY][newX] = 'X';
                    }
                }
            }
            // After one level of searching, increase len
            len++;
        }
        return -1;
    }
}