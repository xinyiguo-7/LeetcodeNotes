// Time Complexity: O(N) - N is the larger length of l1 or l2
// Space Complexity: O(N)
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode head = res;
        int carry = 0, val = 0;
        while(l1 != null || l2 != null) {
            int digit1 = l1 == null? 0 : l1.val;
            int digit2 = l2 == null? 0 : l2.val;
            val = (digit1 + digit2 + carry) % 10;
            carry = (digit1 + digit2 + carry) / 10;
            res.next = new ListNode(val);
            res = res.next;
            l1 = l1 == null? null : l1.next;
            l2 = l2 == null? null : l2.next;
        }
        if(carry != 0) {
            res.next = new ListNode(carry);
        }
        return head.next;
    }
}