// Time Complexity: O(NlogN) - Merge sort
// Space Complexity: O(logN) - Maximum depth of recursion sort
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        // Find mid point of the linked list
        ListNode mid = head;
        ListNode end = head;
        while(end.next != null && end.next.next != null) {
            mid = mid.next;
            end = end.next.next;
        }
        ListNode midPrev = mid;
        mid = mid.next;
        // Disconnect the 1st half and 2nd half of the linked list to avoid redundant loops
        midPrev.next = null;
        // Continue to split the list into left and right sub parts
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        // merge the left and right lists
        return merge(left, right);
    }
    
    // Merge two sorted lists
    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode();
        ListNode head = sentinel;
        
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                head.next = l1;
                head = head.next;
                l1 = l1.next;
            } else {
                head.next = l2;
                head = head.next;
                l2 = l2.next;
            }
        }
        head.next = l1 == null ? l2 : l1;
        return sentinel.next;
    }
}