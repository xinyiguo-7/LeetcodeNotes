// Approach: Sort points by distance using comparator
// Time Complexity: O(NlogN)
// Space Complexity: O(logN) to O(N)
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Comparator<int[]> newComp = new Comparator<int[]>(){
            @Override
            public int compare(int[] point1, int[] point2) {
                int squareDist1 = (int)(Math.pow(point1[0], 2) + Math.pow(point1[1], 2));
                int squareDist2 = (int)(Math.pow(point2[0], 2) + Math.pow(point2[1], 2));
                if(squareDist1 < squareDist2) {
                    return -1;
                } else if (squareDist1 > squareDist2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };
        
        Arrays.sort(points, newComp);
        int [][] res = new int[k][];
        for(int i = 0; i < k; i++) {
            res[i] = points[i];
        }
        return res;
    }
}

// Leetcode solution2: MaxHeap/MaxQueue
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Use a lambda comparator to sort the PQ by farthest distance
        Queue<int[]> maxPQ = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < points.length; i++) {
            int[] entry = {squaredDistance(points[i]), i};
            if (maxPQ.size() < k) {
                // Fill the max PQ up to k points
                maxPQ.add(entry);
            } else if (entry[0] < maxPQ.peek()[0]) {
                // If the max PQ is full and a closer point is found,
                // discard the farthest point and add this one
                maxPQ.poll();
                maxPQ.add(entry);
            }
        }
        
        // Return all points stored in the max PQ
        int[][] answer = new int[k][2];
        for (int i = 0; i < k; i++) {
            int entryIndex = maxPQ.poll()[1];
            answer[i] = points[entryIndex];
        }
        return answer;
    }
    
    private int squaredDistance(int[] point) {
        // Calculate and return the squared Euclidean distance
        return point[0] * point[0] + point[1] * point[1];
    }
};