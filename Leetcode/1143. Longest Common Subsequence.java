// My solution that didn't work well
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int res = 0;
        
        for(int i = 0; i < text1.length(); i++) {
            int length = 0;
            for(int j = 0; j < text2.length(); j++) {
                if(text1.charAt(i) == text2.charAt(j)) {
                    int idx1 = i, idx2 = j;
                    length = 0;
                    while(idx1 < text1.length() && idx2 < text2.length()) {
                        for(int k = idx2; k < text2.length() && idx1 < text1.length(); k++) {
                            if(text1.charAt(idx1) == text2.charAt(k)) {
                                length++;
                                idx1++;
                                idx2 = k + 1;
                            }
                        }
                        idx1++;
                        // idx2++;
                    }
                }
                if(length > res) {
                    res = length;
                }
            }
        }
        return res;
    }
}

// Dynamic programming solution using 2D array
// Time Complexity: O(M * N)
// Space Complexity: O(M * N)
class Solution {
    
    public int longestCommonSubsequence(String text1, String text2) {    
      
      // Make a grid of 0's with text2.length() + 1 columns 
      // and text1.length() + 1 rows.
      int[][] dpGrid = new int[text1.length() + 1][text2.length() + 1];
          
      // Iterate up each column, starting from the last one.
      for (int col = text2.length() - 1; col >= 0; col--) {
        for (int row = text1.length() - 1; row >= 0; row--) {
          // If the corresponding characters for this cell are the same...
          if (text1.charAt(row) == text2.charAt(col)) {
            dpGrid[row][col] = 1 + dpGrid[row + 1][col + 1];
          // Otherwise they must be different...
          } else {
            dpGrid[row][col] = Math.max(dpGrid[row + 1][col], dpGrid[row][col + 1]);
          }
        }
      }
          
      // The original problem's answer is in dp_grid[0][0]. Return it.
      return dpGrid[0][0];
    }
  }


  class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dpGrid = new int[text1.length() + 1][text2.length() + 1];
        
        for(int i = 1; i < text1.length() + 1; i++) {
            for(int j = 1; j < text2.length() + 1; j++) {
                if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dpGrid[i][j] = 1 + dpGrid[i - 1][j - 1];
                } else {
                    dpGrid[i][j] = Math.max(dpGrid[i - 1][j], dpGrid[i][j - 1]);
                }
            }
        }
        return dpGrid[text1.length()][text2.length()];
    }
}