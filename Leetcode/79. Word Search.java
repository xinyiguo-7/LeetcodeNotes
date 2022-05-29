// Time Complexity: O(3^L * N) - L: length of the word to be matched N: number of characters in board
// Space Complexity: O(L)
// Approach: DFS + Backtracking
class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    // Since we don't want the search algo going backword to use the same character, we need to mark visited cells
                    int[][] visited = new int[board.length][board[0].length];
                    if(dfs(board, visited, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean dfs(char[][] board, int[][] visited, String word, int r, int c, int index) {
        boolean found = false;
        
        if(index == word.length()) {
            return true;
        }
        if(r >= 0 && c >= 0 && r < board.length && c < board[0].length && visited[r][c] == 0) {
            if(word.charAt(index) == board[r][c]) {
                // Only mark visited when the character is used, because in some cases we need to explore the same char multiple times
                visited[r][c] = 1;
                found = dfs(board, visited, word, r + 1, c, index + 1) ||
                    dfs(board, visited, word, r - 1, c, index + 1) ||
                    dfs(board, visited, word, r, c + 1, index + 1) ||
                    dfs(board, visited, word, r, c - 1, index + 1);
                // unmark the character to backtrack
                visited[r][c] = 0;
            }
        }
        return found;
    }
}