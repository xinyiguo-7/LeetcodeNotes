// Time Complexity: O(N)
// Space Complexity: O(N)
// Approach: Dynamic Programming
class Solution {
    public int numDecodings(String s) {
        // dp[i] corresponds to the ith character of s, indexed i - 1
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;  // dp[0] = 1 no matter what
        if(s.charAt(0) == '0') {    // if s[0] is 0 then there is no way to decode
            dp[1] = 0;
        } else {
            dp[1] = 1;
        }
        for(int i = 2; i < dp.length; i++) {
            // adding a non-zero digit does not change the total ways of decoding
            if(s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }
            // if twoDigits number is valid, add dp[i - 2] to it
            int twoDigits = Integer.valueOf(s.substring(i - 2, i));
            if(twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}