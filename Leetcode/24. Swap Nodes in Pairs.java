// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode sentinel = new ListNode();
        sentinel.next = head;
        ListNode prev = sentinel;
        
        while(head != null && head.next != null) {
            ListNode nextNode = head.next;
            head.next = nextNode.next;
            nextNode.next = head;
            prev.next = nextNode;
            // Be careful that now head and nextNode has changed position,
            // so just move head to the next node instead of head.next.next
            head = head.next;
            prev = prev.next.next;
        }
        return sentinel.next;
    }
}