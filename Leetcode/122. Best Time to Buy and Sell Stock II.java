// Approach: One pass
// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}