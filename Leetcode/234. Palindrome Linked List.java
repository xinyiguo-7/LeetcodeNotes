// Time Complexity: O(N)
// Space Complexity: O(N)
class Solution {
    public boolean isPalindrome(ListNode head) {
        LinkedList<ListNode> stack = new LinkedList<>();
        
        ListNode end = head;
        while(end != null && end.next != null) {
            stack.add(head);
            head = head.next;
            end = end.next.next;
        }
        if(end != null) {
            stack.add(head);
        }
        while(!stack.isEmpty() && head != null) {
            if(stack.removeLast().val != head.val) {
                return false;
            }
            head = head.next;
        }
        if(!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}