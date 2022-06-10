// Time Complexity: O(M + N)
// Space Complexity: O(M + N)
// Approach: use two lists to save all the traversed nodes for headA and headB
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        List<ListNode> traversedA = new ArrayList<>();
        List<ListNode> traversedB = new ArrayList<>();
        
        while(headA != null || headB != null) {
            if(headA != null) {
                if(traversedB.contains(headA)) {
                    return headA;
                } else {
                    traversedA.add(headA);
                }
                headA = headA.next;
            }
            if(headB != null) {
                if(traversedA.contains(headB)) {
                    return headB;
                } else {
                    traversedB.add(headB);
                }
                headB = headB.next;
            }
        }
        return null;
    }
}