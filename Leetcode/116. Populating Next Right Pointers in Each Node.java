// Approach 1: BFS - traversal level by level
// Time Complexity: O(N)
// Space Complexity: O(N)
class Solution {
    public Node connect(Node root) {
        Queue<Node> level = new LinkedList<>();
        level.add(root);
        
        while(!level.isEmpty()) {
            Queue<Node> nextLevel = new LinkedList<>();
            while(!level.isEmpty()) {
                Node n = level.poll();
                if(n != null) {
                    if(n.left != null) {
                        nextLevel.add(n.left);
                    }
                    if(n.right != null) {
                        nextLevel.add(n.right);
                    }
                    n.next = level.peek();
                }
            }
            level = nextLevel;  
        }
        return root;
    }
}

// Approach 2: Use previously established next pointers
// Time Complexity: O(N)
// Space Complexity: O(N)
class Solution {
    public Node connect(Node root) {
        
        if (root == null) {
            return root;
        }
        
        // Start with the root node. There are no next pointers
        // that need to be set up on the first level
        Node leftmost = root;
        
        // Once we reach the final level, we are done
        while (leftmost.left != null) {
            
            // Iterate the "linked list" starting from the head
            // node and using the next pointers, establish the 
            // corresponding links for the next level
            Node head = leftmost;
            
            while (head != null) {
                
                // CONNECTION 1
                head.left.next = head.right;
                
                // CONNECTION 2
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                
                // Progress along the list (nodes on the current level)
                head = head.next;
            }
            
            // Move onto the next level
            leftmost = leftmost.left;
        }
        
        return root;
    }
}