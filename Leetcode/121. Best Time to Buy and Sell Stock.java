// Approach 1: Try all the possible combinations, will exceed time limit
// Time Complexity: O(N^2)
// Space Complexity: O(1)
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2) {
            return 0;
        }
        int profit = 0;
        
        for(int i = 1; i < prices.length; i++) {
           for(int j = 0; j < i ; j++) {
               if(prices[i] - prices[j] > profit) {
                   profit = prices[i] - prices[j];
               }
           }
        }
        return profit;
    }
}

// Approach 2: One Pass
// Time Complexity: O(N)
// Space Complexity: O(1)
public class Solution {
    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            // Only if current price create a larger profit with current min price, update max profit
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
}