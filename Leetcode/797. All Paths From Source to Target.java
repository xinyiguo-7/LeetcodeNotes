// Time Complexity: O(2^N * N)
// Space Complexity: O(2^N * N)
// Approach: DFS + Backtracking
class Solution {
    private List<List<Integer>> res = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) { 
        // Create path as a LinkedList so that removing last element become easy
        // add the first node to kick off backtracking
        LinkedList<Integer> path = new LinkedList<>();
        path.add(0);
        backTrack(graph, 0, path);
        return res;
    }
    
    public void backTrack(int[][] graph, int node, LinkedList<Integer> path) {
        // Base case: reached the target, then add current path to results
        if(node == graph.length - 1) {
            res.add(new ArrayList<Integer>(path));
        }
        // For each iteration, add the next node to path, then call backTrack on next node
        // Pop the last element out so that it goes back to previous node and start the next exploration
        for(int j = 0; j < graph[node].length; j++) {
            path.add(graph[node][j]);
            backTrack(graph, graph[node][j], path);
            path.removeLast();
        }
    }
}

