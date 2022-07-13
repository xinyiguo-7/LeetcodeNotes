// Approach: Brute force
// Time Complexity: O(N)
// Space Complexity: O(N ^ 2)
class TicTacToe {
    private int[][] board;
    
    public TicTacToe(int n) {
        board = new int[n][n];
    }
    
    public int move(int row, int col, int player) {
        board[row][col] = player;
        return winningCheck(row, col, player);
    }
    
    public int winningCheck(int row, int col, int player) {
        int H = board.length, W = board[0].length;
        boolean win = true;
        // check row
        for(int i = 0; i < W; i++) {
            if(board[row][i] != player) {
                win = false;
                break;
            }
        }
        if(win == true)
            return player;
        
        win = true;
        // check col
        for(int j = 0; j < H; j++) {
            if(board[j][col] != player) {
                win = false;
                break;
            }
        }
        if(win == true)
            return player;
        
        // check diagonal
        if(row == col) {
            win = true;
            for(int k = 0; k < H; k++) {
                if(board[k][k] != player) {
                    win = false;
                    break;
                }
            }
            if(win == true)
                return player;
            
        }
        if(row + col == H - 1) {
            win = true;
            for(int c = W - 1; c >= 0; c--) {
                if(board[H - 1 - c][c] != player) {
                    win = false;
                    break;
                }
            }
            if(win == true)
                return player;
        }
        return win == true ? player : 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */

 // Optimal approach: save each row/column status as a value
 // mark players as 1 and -1. If each value reached n(positive
 // or negative), then current player reached winning status.
 // Time Complexity: O(1)
 // Space Complexity: O(N)
public class TicTacToe {
    int[] rows;
    int[] cols;
    int diagonal;
    int antiDiagonal;

    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
    }

    public int move(int row, int col, int player) {
        int currentPlayer = (player == 1) ? 1 : -1;
        // update currentPlayer in rows and cols arrays
        rows[row] += currentPlayer;
        cols[col] += currentPlayer;
        // update diagonal
        if (row == col) {
            diagonal += currentPlayer;
        }
        //update anti diagonal
        if (col == (cols.length - row - 1)) {
            antiDiagonal += currentPlayer;
        }
        int n = rows.length;
        // check if the current player wins
        if (Math.abs(rows[row]) == n ||
                Math.abs(cols[col]) == n ||
                Math.abs(diagonal) == n ||
                Math.abs(antiDiagonal) == n) {
            return player;
        }
        // No one wins
        return 0;
    }
}
