// Approach: Use a 2D set to store numbers that have appeared
// for each row, column, and box
// Note: HashSet does not have get(index) method(arrayList has)
class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<HashSet<Character>> rows = new ArrayList<>();
        List<HashSet<Character>> cols = new ArrayList<>();
        List<HashSet<Character>> boxes = new ArrayList<>();
        
        // Build 3 2D sets for future use
        for(int i = 0; i < 9; i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            boxes.add(new HashSet<>());
        }
        
        for(int r = 0; r < 9; r++) {
            for(int c = 0; c < 9; c++) {
                if(board[r][c] != '.') {
                    if(rows.get(r).contains(board[r][c])) {
                        return false;
                    }
                    rows.get(r).add(board[r][c]);

                    if(cols.get(c).contains(board[r][c])) {
                        return false;
                    }
                    cols.get(c).add(board[r][c]);

                    int boxIdx = (r/3)*3 + c/3;
                    if(boxes.get(boxIdx).contains(board[r][c])) {
                        return false;
                    }
                    boxes.get(boxIdx).add(board[r][c]);
                }
            }
        }
        return true;
    }
}


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