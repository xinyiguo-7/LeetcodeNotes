// Time Complexity: O(N^3) - two nested loops and a substring computation
// Space Complexity: O(N)
// Approach: Dynamic Programming
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i < s.length() + 1; i++) {
            for(int j = 0; j < i; j++) {
                // The substring can be considered as a word satisfying two conditions:
                // 1. It is a possible end of previous word
                // 2. wordDict contains this word
                if(dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}