// Time Complexity: O(∑k=1 - N (N choose k))
// Space Complexity: O(N)
// Approach: Backtracking
// To avoid duplicate, view each unique number as a choice to put in permutations

class Solution {
    private int N;
    public List<List<Integer>> permuteUnique(int[] nums) {
        N = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        backtrack(map, new LinkedList<>(), res);
        
        return res;
    }
    
    public void backtrack(HashMap<Integer, Integer> map, LinkedList<Integer> permutation, List<List<Integer>> res) {
        if(permutation.size() == N) {
            res.add(new ArrayList(permutation));
            return;
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            if(count > 0) {
                permutation.add(num);
                map.put(num, count - 1);
                backtrack(map, permutation, res);
                map.put(num, count);
                permutation.removeLast();
            }
        }
    }
}