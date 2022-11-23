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

// Time Complexity: O(N)
// Space Complexity: Worst case: O(N), Best case: O(logN) for balanced tree
// Approach: DFS

class Solution {
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }
    
    public int dfs(TreeNode curNode) {
        if(curNode == null) {
            return 0;
        }
        return 1 + Math.max(dfs(curNode.left), dfs(curNode.right));
    }
}