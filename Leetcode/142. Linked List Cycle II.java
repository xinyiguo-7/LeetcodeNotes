// Time Complexity: O(N)
// Space Complexity: O(N)
// Approach: Hash Table
public class Solution {
    public ListNode detectCycle(ListNode head) {
        List<ListNode> traversed = new ArrayList<>();
        
        while(head != null && !traversed.contains(head)) {
            traversed.add(head);
            head = head.next;
        }
        return head;
    }
}