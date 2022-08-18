// Time Complexity: O(N)  - every node only traversed once
// Space Complexity: O(N)
class Solution {
    public int findClosestLeaf(TreeNode root, int k) {
        // Use depth-first search to record each node and edges
        HashMap<TreeNode, List<TreeNode>> graph = new HashMap<>();
        dfs(graph, root, null); // A null node will be added to key set
        
        Queue<TreeNode> q = new LinkedList<>();
        // Use a seen set to contain traversed node and speed up bfs
        Set<TreeNode> seen = new HashSet<>();
        
        for(TreeNode node : graph.keySet()) {
            if(node != null && node.val == k) {
                q.add(node);
                seen.add(node);
            }
        }
        
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node != null) {
                if(graph.get(node).size() <= 1) {
                    return node.val;
                }
                for(TreeNode next : graph.get(node)) {
                    if(!seen.contains(next)) {
                        seen.add(next);
                        q.add(next);
                    }
                }
            }
        }
        return 0;
    }
    
    public void dfs(HashMap<TreeNode, List<TreeNode>> graph, TreeNode node, TreeNode parent) {
        if(node != null) {
            if(!graph.containsKey(node)) {
                graph.put(node, new LinkedList<TreeNode>());
            }
            if(!graph.containsKey(parent)) {
                graph.put(parent, new LinkedList<TreeNode>());
            }
            graph.get(parent).add(node);
            graph.get(node).add(parent);
            dfs(graph, node.left, node);
            dfs(graph, node.right, node);
        }
    }
}