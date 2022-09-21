// Update on 9/19, through process is as following:
// Approach 1: traverse the list twice
// Once set the next ptr, twice set the random ptr
// Approach 2: use an list to store nodes that haven't assign random ptr yet
//              and another list to store copied list
// Approach 3: use a map to store original nodes -> mapping to copied nodes
class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node sentinel = head;
        
        while(head != null) {
            if(!map.containsKey(head)) {
                Node newNode = new Node(head.val);
                map.put(head, newNode);
            }
            if(head.next != null && !map.containsKey(head.next)) {
                Node newNode = new Node(head.next.val);
                map.put(head.next, newNode);
            }
            if(head.random != null && !map.containsKey(head.random)) {
                Node newNode = new Node(head.random.val);
                map.put(head.random, newNode);
            }
            map.get(head).next = map.get(head.next);
            map.get(head).random = map.get(head.random);
            head = head.next;
        }
        return map.get(sentinel);
    }
}


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