// Time Complexity: O(N^2)
// Space Complexity: O(N)
// Approach: HashSet
// Use HashSet to store elements appeared in Sudoku by row, col and box.
// If there is a duplicate that violate the rule, return false.
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int N = 9;
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];
        
        for(int i = 0; i < N; i++) {
            rows[i] = new HashSet();
            cols[i] = new HashSet();
            boxes[i] = new HashSet();
        }
        
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                if(board[r][c] == '.')
                    continue;
                
                if(rows[r].contains(board[r][c]))
                    return false;
                rows[r].add(board[r][c]);
                
                if(cols[c].contains(board[r][c]))
                    return false;
                cols[c].add(board[r][c]);
                
                // Box indexes are triky to compute
                int boxIdx = (r / 3) * 3 + c / 3;
                if(boxes[boxIdx].contains(board[r][c]))
                    return false;
                boxes[boxIdx].add(board[r][c]);
            }
        }
        return true;
    }
}