// Approach: use DFS to find if there is any back edge(if the graph is a DAG)
// Time Complexity: O(|E| + |V|)
// Optimize by using boolean arrays as visited and detected(checked) lists
class Solution {
    HashSet<Integer> visited = new HashSet<>();
    HashSet<Integer> detected;
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // To use DFS, construct a graph first
        // A graph is usually a node followed by a list of its adjacent nodes
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge : prerequisites) {
            if(graph.containsKey(edge[0])) {
                graph.get(edge[0]).add(edge[1]);
            } else {
                List<Integer> newList = new ArrayList<>();
                newList.add(edge[1]);
                graph.put(edge[0], newList);
            }
        }
        
        detected = new HashSet<>();
        boolean hasCycle = false;
        for(int node : graph.keySet()) {
            if(!detected.contains(node)) {
                visited = new HashSet<>();
                hasCycle = dfs(node, graph);
                if(hasCycle)
                    return false;
            }
        }
        return true;
    }
    
    public boolean dfs(int curr, HashMap<Integer, List<Integer>> graph) {
        if(detected.contains(curr)) {
            return false;
        }
        if(visited.contains(curr))
            return true;
        
        if(!graph.containsKey(curr))
            return false;
        
        visited.add(curr);
        boolean hasCycle = false;
        for(int adjNode : graph.get(curr)) {
            hasCycle = dfs(adjNode, graph);
            if(hasCycle)
                break;
        }
        detected.add(curr);
        return hasCycle;
    }
}

// Approach: Post-order DFS
// Idea: If the entire graph is acyclic, then we can finish the courses
// Time Complexity: O(|E| + |V|)
// Space Complexity: O(|E| + |V|)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> courseDict = new HashMap<>();
        // construct a graph
        for(int[] relation : prerequisites) {
            if(courseDict.containsKey(relation[1])) {
                courseDict.get(relation[1]).add(relation[0]);
            } else {
                List<Integer> nextCourses = new LinkedList<>();
                nextCourses.add(relation[0]);
                courseDict.put(relation[1], nextCourses);
            }
        }
        
        boolean[] checked = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        // We can finish the course if the graph is acyclic
        // Otherwise we cannot
        for(int course = 0; course < numCourses; course++) {
            if(isCyclic(course, courseDict, checked, visited)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isCyclic(int course, HashMap<Integer, List<Integer>> courseDict, boolean[] checked, boolean[] visited) {
        if(checked[course]) {
            return false;
        }
        if(visited[course]) {
            return true;
        }
        if(!courseDict.containsKey(course)) {
            return false;
        }
        // before detecting cycle, mark the course as visited
        // and result as false
        visited[course] = true;
        boolean res = false;
        for(Integer nextCourse : courseDict.get(course)) {
            res = isCyclic(nextCourse, courseDict, checked, visited);
            if(res) {
                break;
            }
        }
        // After visiting the children, we still want to process the node itself, so remove from visited
        visited[course] = false;
        // Mark node as checked
        checked[course] = true;
        return res;
    }
    
}