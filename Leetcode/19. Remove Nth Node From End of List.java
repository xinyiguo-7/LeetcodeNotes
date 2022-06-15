// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentinel = new ListNode();
        sentinel.next = head;
        ListNode prev = sentinel;
        
        ListNode curr = prev;
        for(int i = 0; i < n; i++) {
            curr = curr.next;
        }
        while(curr != null && curr.next != null) {
            prev = prev.next;
            curr = curr.next;
        }
        prev.next = prev.next.next;
        return sentinel.next;
    }
}