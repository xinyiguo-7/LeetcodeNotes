// Time Complexity: O(M * N)
// Space Complexity: O(M * N)
// Approach: DFS.
class Solution {    
    private boolean res = false;
    
    public void solve(char[][] board) {
        // Use an array of same size of board to mark visited
        int[][] visited = new int[board.length][board[0].length];
        // Use a Queue to store squares that should be flipped
        Queue<int[]> Q;
        // Loop through all cells not on border
        for(int i = 1; i < board.length - 1; i++) {
            for(int j = 1; j < board[0].length - 1; j++) {
                // If a candidate cell is found, trigger dfs
                if(board[i][j] == 'O' && visited[i][j] == 0) {
                    Q = new LinkedList<>();
                    res = false;
                    if(!checkOnBorder(i, j, Q, board, visited)) {
                        while(Q.size() > 0) {
                            int[] cell = Q.poll();
                            board[cell[0]][cell[1]] = 'X';
                        }
                    }
                }
            }
        }
    }
    
    public boolean checkOnBorder(int i, int j, Queue<int[]> Q, char[][] board, int[][] visited) {
        // If an connected cell on board, mark res as true and mark visited
        if((i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1) && board[i][j] == 'O') {
            visited[i][j] = 1;
            res = true;
        }
        // If an 'O' is within the border and not visited, mark visited, add to queue, and explore surroundings
        if(i >= 0 && i < board.length && j >= 0 && j <= board[0].length 
           && board[i][j] == 'O' && visited[i][j] == 0) {
            visited[i][j] = 1;
            
            checkOnBorder(i - 1, j, Q, board, visited);
            checkOnBorder(i + 1, j, Q, board, visited);
            checkOnBorder(i, j - 1, Q, board, visited);
            checkOnBorder(i, j + 1, Q, board, visited);
            Q.add(new int[]{i, j});
        }
        // Return whether the cell is connected to cells on border
        return res;
    }
}