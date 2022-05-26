// Time Complexity: O(N^2)
// Space Complexity: O(1)
// Approach 1: Find all possible subarrays.
// Drawback: time limit exceeded
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for(int left = 0; left < nums.length; left++) {
            int sum = 0;
            for(int right = left; right < nums.length; right++) {
                sum += nums[right];
                if(sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}

// Approach 2: Using HashMap
// If the cumulative sum (sum[i]) up to two indices (i and j) is the same,
// then sum of the elements lying in between those indices is zero. 
// Extending the same thought further, if the cumulative sum up to two indices, say i and j is at a difference of k
// i.e. if sum[i] - sum[j] = k, the sum of elements lying between indices i and j is k.
// So we use a map to store cumulative sums and their occurrences. Once we found a sumi that satisfies
// above condition, we add to count;

// Time Complexity: O(N)
// Space Complexity: O(N)
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        // Map stores (sumi, number of occurrences of sumi)
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}