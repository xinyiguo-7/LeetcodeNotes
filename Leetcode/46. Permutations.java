// Time Complexity: O(N^2)
// Space Complexity: O(N^2)
// Approach: Backtracking
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums.length, nums, new LinkedList<>(), res);
        return res;
    }
    
    public void backtrack(int length, int N, int[] nums, LinkedList<Integer> permutation, List<List<Integer>> res) {
        if(length == N) {
            res.add(new ArrayList(permutation));
        }
        for(int i = 0; i < nums.length; i++) {
            if(!permutation.contains(nums[i])) {
                permutation.add(nums[i]);
                backtrack(length + 1, N, nums, permutation, res);
                permutation.removeLast();
            }
        }
    }
}