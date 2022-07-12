// Time Complexity: O(M * N)
// Space Complexity: O(M * N)
class Solution {
    public void gameOfLife(int[][] board) {
        int numRows = board.length;
        int numCols = board[0].length;
        int[][] nextState = new int[numRows][numCols];
        
        for(int a = 0; a < numRows; a++) {
            System.arraycopy(board[a], 0, nextState[a], 0, numCols);
        }
        
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < numCols; j++) {
                int liveNum = liveNeighbors(board, i, j);
                
                if(board[i][j] == 1) {
                    if(liveNum < 2) {
                        nextState[i][j] = 0;
                    } else if (liveNum < 4) {
                        nextState[i][j] = 1;
                    } else {
                        nextState[i][j] = 0;
                    }
                } else {
                    if(liveNum == 3) {
                        nextState[i][j] = 1;
                    }
                }
            }
        }
        
        for(int a = 0; a < numRows; a++) {
            System.arraycopy(nextState[a], 0, board[a], 0, numCols);
        }
    }
    
    public int liveNeighbors(int[][] board, int r, int c) {
        int count = 0;
        int height = board.length;
        int width = board[0].length;
        
        if(c - 1 >= 0 && board[r][c - 1] == 1) {
            count++;
        }
        if(c + 1 < width && board[r][c + 1] == 1) {
            count++;
        }
        if(r - 1 >= 0 && board[r - 1][c] == 1) {
            count++;
        }
        if(r + 1 < height && board[r + 1][c] == 1) {
            count++;
        }
        if(r - 1 >= 0 && c - 1 >= 0 && board[r - 1][c - 1] == 1) {
            count++;
        }
        if(r - 1 >= 0 && c + 1 < width && board[r - 1][c + 1] == 1) {
            count++;
        }
        if(r + 1 < height && c - 1 >= 0 && board[r + 1][c - 1] == 1) {
            count++;
        }
        if(r + 1 < height && c + 1 < width && board[r + 1][c + 1] == 1) {
            count++;
        }
        return count;
    }
}