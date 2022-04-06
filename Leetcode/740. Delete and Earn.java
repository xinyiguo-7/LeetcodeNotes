// Approach: Bottom-Up Dynamic Programming
// Time Complexity: O(N + k)
// Space Complexity: O(N + k)
//  where k is the difference between array length and max number

// First loop through the array to store points can get from each number
// Then create an array to store max possible score, and solve a House Robber problem
class Solution {
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> points = new HashMap<>();
        int maxNum = 0;
        
        for(int i = 0; i < nums.length; i++) {
            points.put(nums[i], nums[i] + points.getOrDefault(nums[i], 0));
            maxNum = Math.max(maxNum, nums[i]);
        }
        
        int[] maxScore = new int[maxNum + 1];
        // points we can get from 0
        maxScore[0] = 0;
        // points we can get from 1
        maxScore[1] = points.getOrDefault(1, 0);
        // loop from 2 to n, find the max possible score we can earn without adding adjacent numbers
        for(int n = 2; n < maxScore.length; n++) {
            int gain = points.getOrDefault(n, 0);
            maxScore[n] = Math.max(maxScore[n - 1], maxScore[n - 2] + gain);
        }
        // QUESTION: WHY THE FOLLOWING DOES NOT WORK ??? (It works in the original House Robber question)
        // for(int n = 1; n < maxScore.length; n++) {
        //     int gain = points.getOrDefault(n, 0);
        //     maxScore[n + 1] = Math.max(maxScore[n], maxScore[n - 1] + gain);
        // }
        return maxScore[maxNum];
    }
}


// This approach updates HashMap earnedMap as looping through the nums array
// Which wouldn't work because it decides whether to keep or delete an elment
// only by current ith element.
class Solution {
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> earnedMap = new HashMap<>();
        int[] maxScore = new int[nums.length];
        
        maxScore[0] = nums[0];
        earnedMap.put(nums[0], nums[0]);
        for(int i = 1; i < nums.length; i++) {
            earnedMap.put(nums[i], nums[i] + earnedMap.getOrDefault(nums[i], 0));
            if(earnedMap.containsKey(nums[i] - 1)) {
                if(earnedMap.get(nums[i] - 1) <= earnedMap.get(nums[i])) {
                    maxScore[i] = earnedMap.get(nums[i]);
                    earnedMap.remove(nums[i] - 1);
                } else {
                    maxScore[i] = maxScore[i-1];
                }
            } else if(earnedMap.containsKey(nums[i] + 1)) {
                if(earnedMap.get(nums[i] + 1) <= earnedMap.get(nums[i])) {
                    maxScore[i] = earnedMap.get(nums[i]);
                    earnedMap.remove(nums[i] + 1);
                } else {
                    maxScore[i] = maxScore[i-1];
                }
            } else {
                maxScore[i] = maxScore[i-1] + nums[i];
            }
        }
        return maxScore[nums.length-1];
    }
}