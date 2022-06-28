// Time Complexity: O(N)
// Space Complexity: O(N)
class Solution {
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>();

        for(String str : tokens) {
            if(str.equals("+") && (stack.size() >= 2)) {
                int num1 = stack.removeLast();
                int num2 = stack.removeLast();
                stack.add(num2 + num1);
            } else if(str.equals("-") && stack.size() >= 2) {
                int num1 = stack.removeLast();
                int num2 = stack.removeLast();
                stack.add(num2 - num1);
            } else if(str.equals("*") && stack.size() >= 2) {
                int num1 = stack.removeLast();
                int num2 = stack.removeLast();
                stack.add(num2 * num1);
            } else if(str.equals("/") && stack.size() >= 2) {
                int num1 = stack.removeLast();
                int num2 = stack.removeLast();
                stack.add(num2 / num1);
            } else if(str.charAt(0) == '-') {
                stack.add(-Integer.valueOf(str.substring(1)));
            } else {
                stack.add(Integer.valueOf(str));
            }
        }
        return stack.removeLast();
    }
}