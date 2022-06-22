// Time Complexity: O(N^2) - N: number of rows
// Space Complexity: O(1)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        row.add(1);
        res.add(row);
        
        for(int i = 1; i < numRows; i++) {
            List<Integer> nextRow = new ArrayList<>();
            nextRow.add(1);
            for(int j = 1; j < i; j++) {
                nextRow.add(row.get(j - 1) + row.get(j));
            }
            nextRow.add(1);
            res.add(new ArrayList(nextRow));
            row = nextRow;
        }
        return res;
    }
}