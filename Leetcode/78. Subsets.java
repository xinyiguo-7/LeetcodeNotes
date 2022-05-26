// Time Complexity: O(2^N * N)
// Space Complexity: O(2^N * N)
// Approach: Cascading. 
// Start with adding an empty list, then loop through all elements in the set
// For each iteration, copy over the subsets we already have, then add current 
// number to the subsets.
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        
        for(int i : nums) {
            List<List<Integer>> temp = new ArrayList<>();
            for(List<Integer> subset : res) {
                List<Integer> a = new ArrayList<>(subset);
                a.add(i);
                temp.add(a);
            }
            res.addAll(temp);
        }
        return res;
    }
}

// Time Complexity: O(2^N * N)
// Space Complexity: O(N)
// Approach: Backtracking

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        // Iterate over possible sizes of subsets
        for(int i = 0; i < nums.length + 1; i++) {
            backtracking(0, new ArrayList<Integer>(), nums, i);
        }
        return res;
    }
    
    public void backtracking(int first, ArrayList<Integer> curr, int[] nums, int currSize) {
        // Base case: When current size has reached required size, 
        // which means a combination is completed, add to current list and return
        if(curr.size() == currSize) {
            res.add(new ArrayList(curr));
            return;
        }
        // Iterate from current first element and all postcedent elements, add them to current list,
        // call backtraking on next element
        // remove last element of the list
        for(int i = first; i < nums.length; i++) {
            curr.add(nums[i]);
            backtracking(i + 1, curr, nums, currSize);
            curr.remove(curr.size() - 1);
        }
    }
}