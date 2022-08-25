// Approach: Top-down DP + Binary Search
// Time Complexity: O(NlogN)
// Space Complexity: O(N)
class Solution {
    int[] memo = new int[50001];    // max number of jobs
    
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<List<Integer>> jobs = new ArrayList<>();
        // mark -1 as we have not calculated the result
        Arrays.fill(memo, -1);
        // store job details as startTime, endTime and profit
        int length = profit.length;
        for(int i = 0; i < length; i++) {
            List<Integer> currJob = new ArrayList<>();
            currJob.add(startTime[i]);
            currJob.add(endTime[i]);
            currJob.add(profit[i]);
            jobs.add(currJob);
        }
        // Sort the jobs according to their start time
        jobs.sort(Comparator.comparingInt(a->a.get(0)));
        
        // Store the sorted start time into the array for binary search
        for(int i = 0; i < length; i++) {
            startTime[i] = jobs.get(i).get(0);
        }
        
        return findMaxProfit(jobs, startTime, length, 0);
    }
    
    private int findMaxProfit(List<List<Integer>> jobs, int[] startTime, int n, int position) {
        // 0 profit if we have iterated over all jobs
        if(position == n) {
            return 0;
        }
        // return result if calculated
        if(memo[position] != -1) {
            return memo[position];
        }
        // find next non-conflicting job index
        int nextIndex = findNextJob(startTime, jobs.get(position).get(1));
        // find max profit of two options: skipping or scheduling the current job
        int maxProfit = Math.max(findMaxProfit(jobs, startTime, n, position + 1), jobs.get(position).get(2) + findMaxProfit(jobs, startTime, n, nextIndex));
        // return max profit and store it to memo
        return memo[position] = maxProfit;
    }
    
    // Use binary search to find next non-conflicting job
    private int findNextJob(int[] startTime, int lastEndingTime) {
        int start = 0, end = startTime.length - 1, nextIndex = startTime.length;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(startTime[mid] >= lastEndingTime) {
                nextIndex = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return nextIndex;
    }
}