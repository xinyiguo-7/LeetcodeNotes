// Time Complexity: O(4^N * N)
// Space Complexity: O(N)
// Approach: Backtracking.

class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) {
            return new ArrayList<>();
        }
        String[] mapping = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        backtrack(mapping, res, digits, 0, new StringBuilder());
        return res;
    }
    
    public void backtrack(String[] mapping, List<String> res, String digits, int index, StringBuilder current) {
        if(index == digits.length()) {
            res.add(current.toString());
            return;
        }
        // The passing parameter index already indicates our current position on digits. So we don't need an extra for loop.
        // for(int i = index; i < digits.length(); i++) {
        String letters = mapping[digits.charAt(index) - '2'];
        for(int j = 0; j < letters.length(); j++) {
            current.append(letters.charAt(j));
            backtrack(mapping, res, digits, index + 1, current);
            current.deleteCharAt(current.length() - 1);
        }
        // }
    }
}