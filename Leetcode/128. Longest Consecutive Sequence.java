// Approach 1: Sorting
// Count the number of longest consecutive array after sorting
// Time Complexity: O(NlogN) - dominated by sort()
// Space Complexity: O(1)
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 1;
        for(int i = 1; i < nums.length; i++) {
            int newLength = 1;
            while(i < nums.length) {
                if(nums[i] == nums[i - 1] + 1) {
                    newLength++;
                    i++;
                } else if(nums[i] == nums[i - 1]) {
                    i++;
                } else {
                    break;
                }
            }
            res = Math.max(newLength, res);
        }
        return res;
    }
}

// Approach 2: HashSet and Intelligent Sequence Building
// Time Complexity: O(N)
// Space Complexity: O(N)
class Solution {
    public int longestConsecutive(int[] nums) {
        // .contains() of HashSet takes O(1) time
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num-1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum+1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
    
}

// 11/27/2023
// Use union find
class Solution {
    public int longestConsecutive(int[] nums) {
        // Map<Integer, Integer> map = new HashMap<>();    // root - number
        Set<Integer> set = new HashSet<>();
        
        for(int n : nums) {
            set.add(n);
        }
        int maxLen = 0;
        for(int n : nums) {
            if(set.contains(n - 1)) {
                int curNum = n;
                int curLen = 1;
                while(set.contains(curNum - 1)) {
                    curNum = curNum -1;
                    curLen++;
                }
                maxLen = Math.max(curLen, maxLen);
            }
        }
        return maxLen;
    }
}