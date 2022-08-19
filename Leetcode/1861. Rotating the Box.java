// Time Complexity: O(N * S) - N is the number of squares in the box, S is the number of stones
// Space Complexity: O(N)
class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int H = box.length, W = box[0].length;
        char[][] rotateBox = new char[W][H];
        
        for(int i = 0; i < W; i++) {
            for(int j = 0; j < H; j++) {
                rotateBox[i][j] = '.';
            }
        }
        for(int r = 0; r < H; r++) {
            int stoneNum = 0;
            int c = 0;
            while(c < W) {
                while(c < W && box[r][c] != '*') {
                    if(box[r][c] == '#')
                        stoneNum++;
                    c++;
                }
                // box[r][c] is a obstacle or c == W
                if(c == W) {
                    c--;
                }
                int[] newIndex = rotateRowCol(r, c, box);
                int rotateRow = newIndex[0];
                int rotateCol = newIndex[1];
                if(box[r][c] == '*') {
                    rotateBox[rotateRow][rotateCol] = '*';
                    rotateRow--;
                }
                while(stoneNum > 0) {
                    rotateBox[rotateRow][rotateCol] = '#';
                    rotateRow--;
                    stoneNum--;
                }
                c++;
            }
        }
        return rotateBox;
    }
    
    public int[] rotateRowCol(int row, int col, char[][] box) {
        int newRow = col;
        int newCol = box.length - row - 1;
        return new int[]{newRow, newCol};
    }
}