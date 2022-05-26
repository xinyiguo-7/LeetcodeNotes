// Time Complexity: O(2^N * N)
// Space Complexity: O(N)
// Approach: Backtracking
// Using same approach as LC 78. Just added an if statement in iterative cases to avoid duplicates and sorted the array before backtracking.
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length + 1; i++) {
            backtracking(0, new ArrayList<>(), nums, i);
        }
        return res;
    }
    
    public void backtracking(int firstIdx, List<Integer> curr, int[] nums, int curSize) {
        if(curr.size() == curSize) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int j = firstIdx; j < nums.length; j++) {
            // If the element is the same as previous and not the first time appear in this function call,
            // it is duplicate
            if(j != firstIdx && nums[j] == nums[j - 1]) {
                continue;
            }
            curr.add(nums[j]);
            backtracking(j + 1, curr, nums, curSize);
            curr.remove(curr.size() - 1);
        }
    }
}