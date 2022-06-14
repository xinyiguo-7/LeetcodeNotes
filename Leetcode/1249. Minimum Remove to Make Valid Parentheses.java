// Time Complexity: O(N)
// Space Complexity: O(M) - number of left parenthesis
class Solution {
    public String minRemoveToMakeValid(String s) {
        LinkedList<Integer> left = new LinkedList<>();
        StringBuilder res = new StringBuilder(s);
        
        for(int i = 0; i < res.length(); i++) {
            if(res.charAt(i) == ')') {
                if(left.isEmpty()) {
                    res.deleteCharAt(i);
                    i--;
                } else {
                    left.removeLast();
                }
            } else if(res.charAt(i) == '(') {
                left.add(i);
            }
        }
        
        while(!left.isEmpty()) {
            res.deleteCharAt(left.removeLast());
        }
        return res.toString();
    }
}