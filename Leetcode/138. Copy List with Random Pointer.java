// Approach: Use a hash map to map the original node to the new node
// Don't use value because some different nodes may have the same value
// Time Complexity: O(N)
// Space Complexity: O(N)
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }
        HashMap<Node, Node> nodeDict = new HashMap<>();
        Node newHead = new Node(head.val);
        nodeDict.put(head, newHead);
        Node res = newHead;
        
        while(head != null) {
            if(head.next != null) {
                if(!nodeDict.containsKey(head.next)) {
                    nodeDict.put(head.next, new Node(head.next.val));
                }
                newHead.next = nodeDict.get(head.next);
            } else {
                newHead.next = null;
            }
            if(head.random != null) {
                if(!nodeDict.containsKey(head.random)) {
                    nodeDict.put(head.random, new Node(head.random.val));
                }
                newHead.random = nodeDict.get(head.random);
            } else {
                newHead.random = null;
            }
            head = head.next;
            newHead = newHead.next;
        }
        return res;
    }
    
}