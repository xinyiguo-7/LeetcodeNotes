// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public void reorderList(ListNode head) {
        // Find the 2nd half of the list
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode reverseHead = slow.next;
        slow.next = null;
        
        // Reverse the 2nd half of the list
        ListNode newHead = null;
        ListNode curr = reverseHead;
        
        while(curr != null) {
            ListNode nextNode = curr.next;
            curr.next = newHead;
            newHead = curr;
            curr = nextNode;
        }
         // Insert the reversed list into the 1st half
        while(head != null && newHead != null) {
            ListNode next1 = head.next;
            ListNode next2 = newHead.next;
            
            head.next = newHead;
            newHead.next = next1;
            head = next1;
            newHead = next2;
        }
    }
}