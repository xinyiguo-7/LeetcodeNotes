// Time Complexity: O(N)
// Space Complexity: O(N)
// Approach: view pairs as nodes connected by edges, and use dfs to traverse them.
class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        // First put number as nodes, and adjacency as edges into a map
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] pair : adjacentPairs) {
            List<Integer> edges0 = graph.getOrDefault(pair[0], new ArrayList<>());
            edges0.add(pair[1]);
            graph.put(pair[0], edges0);
            List<Integer> edges1 = graph.getOrDefault(pair[1], new ArrayList<>());
            edges1.add(pair[0]);
            graph.put(pair[1], edges1);
        }
        
        // Find a node that only have 1 edge
        int start = 0;
        for(int key : graph.keySet()) {
            if(graph.get(key).size() == 1) {
                start = key;
                break;
            }
        }
        // Use dfs to find a path
        Set<Integer> visited = new HashSet<>();
        int[] res = new int[adjacentPairs.length + 1];
        int index = 0;
        while(index < res.length) {
            res[index] = start;
            visited.add(start);
            for(int next : graph.get(start)) {
                if(!visited.contains(next)) {
                    start = next;
                    break;
                }
            }
            index++;
        }
        return res;
    }
}