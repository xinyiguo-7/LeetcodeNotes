// Time Complexity: O(NlogN) - sorting and linear scan of input list
// Space Complexity: O(N) - store a copy of intervals
// Approach: Sorting
// Sort intervals according to their first element, then compare the second element.
// If overlap, then merge. If not, then add current interval to result list.

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> res = new ArrayList<>();
        int[] merged = intervals[0];
        for(int i = 1; i < intervals.length; i++) {
            if(merged[1] >= intervals[i][0]) {
                merged[1] = Math.max(merged[1], intervals[i][1]);
            } else {
                res.add(merged);
                merged = intervals[i];
            }
        }
        res.add(merged);
        return res.toArray(new int[res.size()][]);
    }
}