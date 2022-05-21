// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int count = 0;
        int[] prevInterval = intervals[0];
        for(int i = 1; i < intervals.length; i++) {
            if(prevInterval[1] > intervals[i][0]) {
                count++;
                prevInterval[1] = Math.min(prevInterval[1], intervals[i][1]);
            } else {
                prevInterval = intervals[i];
            }
        }
        return count;
    }
}