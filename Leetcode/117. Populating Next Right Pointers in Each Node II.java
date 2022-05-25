// Time Complexity: O(N)
// Space Complexity: O(N)
// Approach: BFS - Level order traversal.
// Use a Queue to store all the nodes at the same level, assign the pointers and add next level nodes
// at the same time.
class Solution {
    public Node connect(Node root) {
        if(root == null) {
            return root;
        }
        // Initialize Queue and add root as first level
        Queue<Node> Q = new LinkedList<Node>();
        Q.add(root);
        // While there are still nodes in Queue, keep looping
        while(Q.size() > 0) {
            // Get the size of current level of the tree, and the for loop stops after
            // traversing all nodes of this level
            int size = Q.size();
            for(int i = 0; i < size; i++) {
                Node node = Q.poll();
                // Only assign the top node on Q to next when current node is not the last node
                // Otherwise the last node of this level may be pointing to nodes on next level
                if(i < size - 1) {
                    node.next = Q.peek();
                }
                // Add both children of current node to Q to get the next level nodes
                if(node.left != null) {
                    Q.add(node.left);
                }
                if(node.right != null) {
                    Q.add(node.right);
                }
            }
        }
        return root;
    }
}