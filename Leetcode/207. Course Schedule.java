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