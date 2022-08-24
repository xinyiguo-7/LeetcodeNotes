// Approach 1: Sorting
// Since we increase element at i each time by 1, result after 
// increasing equal numbers should be a consecutive sequence.
// Thus, if any number is <= the last element, then it is repeated
// Time Complexity: O(NlogN)
// Space Complexity: O(1)
class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int prev = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            while(nums[i] <= prev) {
                nums[i] += 1;
                count++;
            }
            prev = nums[i];
        }
        return count;
    }
}

// Approach: Counting
// Time Complexity: O(N + M)
// Space Complexity: O(N + M)
class Solution {
    public int minIncrementForUnique(int[] nums) {
        int maxVal = 0;
        for (int x : nums) {
            maxVal = Math.max(maxVal, x);
        }
        // The number will not exceed the array length + maxVal
        int[] count = new int[nums.length + maxVal];
        for (int x : nums) {
            count[x]++;
        }
        
        int moves = 0;  // Count the number of moves needed
        int taken = 0;  // Count the repeated numbers
        for (int x = 0; x < nums.length + maxVal; ++x) {
            // If the count is greater than 1
            if (count[x] >= 2) {
                // Add the duplicate number count
                taken += count[x] - 1;
                // Since the distance from x to 0 will be added later, 
                // and we only need the relative distance from x to a 
                // nonexisting number, we subtract the duplicated 0 to x distance
                moves -= x * (count[x] - 1);
            } else if (taken > 0 && count[x] == 0) {
                taken--;
                moves += x;
            }
        }

        return moves;
    }
}