// My own AC solution
// Time Complexity: O(N^(T/M) + 1) - Let N be the number of candidates, T be the target value, and M be the minimal value among the candidates.
// Space Complexity: O(T/M)
// Approach: Backtracking
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, res, new LinkedList<>(), 0, target, 0);
        return res;
    }
    
    public void backtrack(int[] candidates, List<List<Integer>> res, LinkedList<Integer> combination, int sum, int target, int start) {
        if(sum == target) {
            res.add(new ArrayList(combination));
            return;
        }
        // Let iteration start from index of current element to avoid duplicates
        for(int i = start; i < candidates.length; i++) {
            if(candidates[i] >= 0 && sum < target) {
                sum += candidates[i];
                combination.add(candidates[i]);
                backtrack(candidates, res, combination, sum, target, i);
                sum -= candidates[i];
                combination.removeLast();
            }
        }
    }
}