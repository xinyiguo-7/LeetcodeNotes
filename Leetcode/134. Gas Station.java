// My brute force solution - exceeds time limit
// Time Complexity: O(N^2)
// Space Complexity: O(1)
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int start = 0; start < gas.length; start++) {
            if(check(gas, cost, start)) {
                return start;
            }
        }
        return -1;
    }
    
    public boolean check(int[] gas, int[] cost, int start) {
        int n = gas.length;
        int i = start + 1;
        int tank = gas[start];
        while(i != start) {
            if(i < n) {
                if((i > 0) && (tank - cost[i - 1] >= 0)) {
                    tank = tank - cost[i - 1] + gas[i];
                } else if((i == 0) && (tank - cost[n - 1] >= 0)) {
                    tank = tank - cost[n - 1] + gas[i];
                } else {
                    return false;
                }
                i++;
            } else {
                i = i % n;
            }
        }
        i = i > 0 ? i : n;
        return tank - cost[i - 1] >= 0 ? true : false;
    }
}

// Leetcode one pass solution
// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank = 0;
        int currentTank = 0;
        int startIndex = 0;
        
        for(int i = 0; i < gas.length; i++) {
            // add gas to tank, then subtract the cost
            totalTank += gas[i] - cost[i];
            currentTank += gas[i] - cost[i];
            // If currentTank < 0, which means the car cannot get there
            if(currentTank < 0) {
                // try next position
                startIndex = i + 1;
                // re-initialize current tank
                currentTank = 0;
            }
        }
        // If there is a possible solution for the car to travel a circle, then total tank should >= 0
        return totalTank >= 0 ? startIndex : -1;
    }
}