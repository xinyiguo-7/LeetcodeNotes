class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < candidates.length; i++) {
            map.put(candidates[i], map.getOrDefault(candidates[i], 0) + 1);
        }
        backtrack(map, res, new LinkedList<>(), 0, target);
        return res;
    }
    
    public void backtrack(HashMap<Integer, Integer> map, List<List<Integer>> res, LinkedList<Integer> combination, int sum, int target) {
        if(sum == target) {
            res.add(new ArrayList(combination));
            return;
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            if(num >= (combination.size() == 0 ? 0 : combination.getLast()) 
               && count > 0 && sum < target) {
                sum += num;
                map.put(num, count - 1);
                combination.add(num);
                backtrack(map, res, combination, sum, target);
                sum -= num;
                map.put(num, count);
                combination.removeLast();
            }
        }
    }
}
