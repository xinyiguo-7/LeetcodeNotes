// Dynamic programming solution using 2D array - LC 1143(LCS) + steps computation
// Time Complexity: O(M * N)
// Space Complexity: O(M * N)
// Use the same method as LCS to compute the length of longest subsequence,
// then subtract 2*length from sum of length of two strings, we get the min steps
// to make two strings the same.
class Solution {
  public int minDistance(String word1, String word2) {
      int[][] dpGrid = new int[word1.length() + 1][word2.length() + 1];
      
      for(int i = 1; i < word1.length() + 1; i++) {
          for(int j = 1; j < word2.length() + 1; j++) {
              if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                  dpGrid[i][j] = 1 + dpGrid[i - 1][j - 1];
              } else {
                  dpGrid[i][j] = Math.max(dpGrid[i - 1][j], dpGrid[i][j - 1]);
              }
          }
      }
      int res = word1.length() + word2.length() 
          - 2 * dpGrid[word1.length()][word2.length()];
      return res;
  }
}

// A DP solution without using LCS
public class Solution {
  public int minDistance(String s1, String s2) {
      int[][] dp = new int[s1.length() + 1][s2.length() + 1];
      for (int i = 0; i <= s1.length(); i++) {
          for (int j = 0; j <= s2.length(); j++) {
              if (i == 0 || j == 0)
                  dp[i][j] = i + j;
              else if (s1.charAt(i - 1) == s2.charAt(j - 1))
                  dp[i][j] = dp[i - 1][j - 1];
              else
                  dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
          }
      }
      return dp[s1.length()][s2.length()];
  }
}