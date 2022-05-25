// Time Complexity: O(N^2)
// Space Complexity: O(N)
// Approach: DFS
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int num = 0;
        int[] visited = new int[isConnected.length];
        // Loop through all nodes in the graph
        for(int i = 0; i < visited.length; i++) {        
            // If a node is not visited, add to num and run dfs to find other nodes connected to this node.
            if(visited[i] == 0) {
                num++;
                dfs(isConnected, visited, i);
            } 
        }
        return num;
    }
    
    public void dfs(int[][] isConnected, int[] visited, int i) {
        // Loop through the adjacency matrix for this node
        for(int j = 0; j < isConnected[i].length; j++) {
            // If another node is connected to current one and not visited, mark it as visited and run dfs
            if(isConnected[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(isConnected, visited, j);
            }
        }
    }
}

// Time Complexity: O(M^2 * N^2)
// Space Complexity: O(M * N)
// My own AC solution using DFS.
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int num = 0;
        for(int i = 0; i < isConnected.length; i++) {
            for(int j = 0; j < isConnected[i].length; j++) {
                // If found the first pair of connected cities, trigger dfs algorithm
                if(isConnected[i][j] == 1) {
                    num++;
                    dfs(isConnected, i, j);
                }
            }
        }
        return num;
    }
    
    public void dfs(int[][] isConnected, int i, int j) {
        if(i >= 0 && j >= 0 && i < isConnected.length && j < isConnected[i].length 
           && isConnected[i][j] == 1) {
            // Mark the city as visited
            isConnected[i][j] = 0;
            // Loop through all the row and columns to find directly and indirectly connected cities.
            for(int r = 0; r < isConnected.length; r++) {
                dfs(isConnected, r, j);
            }
            for(int c = 0; c < isConnected[i].length; c++) {
                dfs(isConnected, i, c);
            }
        }
    }
}