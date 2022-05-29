// Time Complexity: O(4^n/sqrt(n))
// Space Complexity: O(4^n/sqrt(n))
// Approach: Backtracking
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(), n, 0, 0);
        return res;
    }
    
    public void backtrack(List<String> res, StringBuilder current, int n, int open, int close) {
        if(close == n) {
            res.add(current.toString());
        }
        if(open < n) {
            current.append('(');
            backtrack(res, current, n, open + 1, close);
            current.deleteCharAt(current.length() - 1);
        }
        if(close < open) {
            current.append(')');
            backtrack(res, current, n, open, close + 1);
            current.deleteCharAt(current.length() - 1);
        }
    }
}