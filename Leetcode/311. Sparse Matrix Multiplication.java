// Time Complexity: O(N * M * O)
// Space Complexity: O(1)
class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        if(mat1[0].length != mat2.length)
            return null;
        int N = mat1.length, M = mat2[0].length;
        int[][] result = new int[N][M];
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                result[i][j] = dotProd(mat1, mat2, i, j);
            }
        }
        return result;
    }
    
    public int dotProd(int[][] mat1, int[][] mat2, int r, int c) {
        int sum = 0;
        int N = mat1[0].length;
        
        for(int i = 0; i < N; i++) {
            sum += mat1[r][i] * mat2[i][c];
        }
        
        return sum;
    }
}