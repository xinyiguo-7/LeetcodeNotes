// Idea1: Brute force
// Loop through every number from 1 to n and see if 
// there is a duplicate in the array
// Time Complexity: O(N^2)
// Space Complexity: O(1)
class Solution {
    public int findDuplicate(int[] nums) {
        for(int i = 1; i < nums.length; i++) {
            int count = 0;
            for(int n : nums) {
                if(i == n) {
                    count++;
                }
                if(count > 1) {
                    return i;
                }
            }
        }
        return 0;
    }
}

// Approach: Binary Search
// If the count of numbers smaller than middle index is greater than the middle index,
// then there is a duplicate in the left sub-array, if not, find the right sub-array.
class Solution {
    public int findDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        int duplicate = -1;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            
            int count = 0;
            for(int num : nums) {
                if(num <= mid) {
                    count++;
                }
            }
            if(count > mid) {
                duplicate = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return duplicate;
    }
}

// Approach: Floyd's Tortoise and Hare (Cycle Detection)
// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public int findDuplicate(int[] nums) {
        
        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];
        
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        tortoise = nums[0];
        
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }

        return hare;
    }
}