
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0) {
            return -1;
        }
        Queue<int[]> Q = new LinkedList<>();
        grid[0][0] = 1;
        Q.add(new int[]{0, 0});
        
        while(Q.size() > 0) {
            int[] cell = Q.poll();
            int row = cell[0];
            int col = cell[1];
            int distance = grid[row][col];
            if(row == grid.length - 1 && col == grid[0].length - 1) {
                return distance;
            }
            
            for(int[] neighbour : getNeighbours(row, col, grid)) {
                grid[neighbour[0]][neighbour[1]] = distance + 1;
                Q.add(new int[]{neighbour[0], neighbour[1]});
            }  
        }
        return -1;
    }
    
    public List<int[]> getNeighbours(int row, int col, int[][] grid) {
        int[][] directions = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        List<int[]> neighbours = new ArrayList<>();
        for(int i = 0; i < directions.length; i++) {
            int newRow = row + directions[i][0];
            int newCol = col + directions[i][1];
            if(newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length && grid[newRow][newCol] == 0) {
                neighbours.add(new int[]{newRow, newCol});
            }
        }
        return neighbours;
    }
}