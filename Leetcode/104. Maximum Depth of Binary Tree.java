// Time Complexity: O(N)
// Space Complexity: O(N)
// Approach: BFS
class Solution {
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> Q = new LinkedList<>();
        int depth = 0;
        if(root != null) {
            Q.add(root);
        }
        
        while(!Q.isEmpty()) {
            Queue<TreeNode> nextQ = new LinkedList<>();
            while(!Q.isEmpty()) {
                TreeNode node = Q.poll();
                if(node.left != null) {
                    nextQ.add(node.left);
                }
                if(node.right != null) {
                    nextQ.add(node.right);
                }
            }
            Q = nextQ;
            depth++;
        }
        return depth;
    }
}