// Approach: Backtracking
// Time Complexity: O(N * 2^N)
// Space Complexity: O(N^2)
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(res, new LinkedList<>(), s, 0, 0);
        return res;
        
    }
    
    public boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while(start <= end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    
    public void backtrack(List<List<String>> res, LinkedList<String> strs, String s, int start, int end) {
        
        if(start >= s.length()) {
            res.add(new ArrayList(strs));
            return;
        }
        
        while(end < s.length()) {
            String currStr = s.substring(start, end + 1);
            // Only if current substring is a palindrome, it is added to current list and start index move on to the next
            if(isPalindrome(currStr)) {
                strs.add(currStr);
                backtrack(res, strs, s, end + 1, end + 1);
                strs.removeLast();
            }
            end++;
        }
    }
}