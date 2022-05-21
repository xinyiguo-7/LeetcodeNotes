
// Approach: Sentinel Head + Predecessor
// Time complexity: O(N)
// Space complexity: O(1)

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Since the head could be removed, we use a sentinel head to keep
        // the head of the list
        ListNode sentinel = new ListNode(0, head);
        ListNode pred = sentinel;

        while(head != null) {
            // How do we update the predecessor depend on whether current
            // node is a duplicate node
            if(head.next != null && head.val == head.next.val) {
                // if is duplicate, keep looping until we find the end of the sequence
                while(head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                // update pred.next so that the duplicates are deleted
                pred.next = head.next;
            } else {
                // if not duplicate, just update as normal
                pred = pred.next;
            }
            // move head forward
            head = head.next;
        }
        return sentinel.next;
    }
}


// Updated on 05/19/2022
// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode sentinel = new ListNode();
        sentinel.next = head;
        ListNode prevNode = sentinel;
        ListNode nextNode = head.next;
        while(head != null && head.next != null) {
            nextNode = head.next;
            if(head.val == nextNode.val) {
                while(nextNode != null && head.val == nextNode.val) {
                    head = head.next;
                    nextNode = nextNode.next;
                }
                prevNode.next = nextNode;
            } else {
                prevNode = prevNode.next;
            }
            head = head.next;
        }
        return sentinel.next;
    }
}