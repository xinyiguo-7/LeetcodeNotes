// Approach 1: Bottom-up dynamic programming
// Time complexity: O(N)
// Space complexity: O(N)

// KEY POINT: The minimum cost of the ith step is
// min(minimumCost[i - 1] + cost[i - 1], minimumCost[i - 2] + cost[i - 2])
// The cost of 1st and 2nd step is 0 because we can go one or two
// step each time

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] minimumCost = new int[cost.length + 1];
        minimumCost[0] = 0;
        minimumCost[1] = 0;
        for(int i = 2; i <= cost.length; i++) {
            minimumCost[i] = Math.min(minimumCost[i - 1] + cost[i - 1],
                                minimumCost[i - 2] + cost[i - 2]);
        }
        return minimumCost[cost.length];
    }
}