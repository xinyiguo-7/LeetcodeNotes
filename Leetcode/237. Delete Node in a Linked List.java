// Time Complexity: O(1)
// Space Complexity: O(1)
class Solution {
    public void deleteNode(ListNode node) {
        if(node == null || node.next == null) {
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }
}