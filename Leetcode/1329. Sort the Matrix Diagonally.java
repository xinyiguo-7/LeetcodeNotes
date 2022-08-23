// Time Complexity: O(M * N * log(min(M, N)))
// Space Complexity: O(max(M, N))
class Solution {
    public int[][] diagonalSort(int[][] mat) {
        // 2 types of diagonal starting point
        // 1. horizontal 2. vertical
        // stop when hit the walls(width/height)
        
        // Visiting once, gather elements and sort
        // Visiting twice, put sorted elements in diagonal
        int H = mat.length, W = mat[0].length;
        
        for(int i = 0; i < W; i++) {
            int r = 0, c = i;
            LinkedList<Integer> diagonal = new LinkedList<>();
            while(r < H && c < W) {
                diagonal.add(mat[r++][c++]);
            }
            Collections.sort(diagonal);
            r = 0;
            c = i;
            while(r < H && c < W) {
                mat[r++][c++] = diagonal.removeFirst();
            }
        }
        
        for(int j = 1; j < H; j++) {
            int r = j, c = 0;
            LinkedList<Integer> diagonal = new LinkedList<>();
            while(r < H && c < W) {
                diagonal.add(mat[r++][c++]);
            }
            Collections.sort(diagonal);
            r = j; c = 0;
            while(r < H && c < W) {
                mat[r++][c++] = diagonal.removeFirst();
            }
        }
        return mat;
    }
}