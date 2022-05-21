// Time Complexity: O(N + M)
// Space Complexity: O(N + M)
// Approach: Merge Intervals. 
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0;
        while(i < firstList.length && j < secondList.length) {
            int low = Math.max(firstList[i][0], secondList[j][0]);
            int high = Math.min(firstList[i][1], secondList[j][1]);
            if(low <= high) {
                res.add(new int[]{low, high});
            }
            // only the interval with higher endpoint can continue to intersect with other intervals
            if(firstList[i][1] < secondList[j][1]) {
                i++;
            } else{
                j++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
// A modified solution from Merge Intervals. But didn't work well.
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
        int[][] concateList = new int[firstList.length + secondList.length][];
        System.arraycopy(firstList, 0, concateList, 0, firstList.length);
        System.arraycopy(secondList, 0, concateList, firstList.length, secondList.length);
        Arrays.sort(concateList, Comparator.comparingInt(a -> a[1]));
        List<int[]> res = new ArrayList<>();
        
        int[] prevInterval = concateList[0];
        for(int i = 1; i < concateList.length; i++) {
            if(prevInterval[1] >= concateList[i][0]) {
                int[] overlap = new int[2];
                overlap[0] = Math.max(prevInterval[0], concateList[i][0]);
                overlap[1] = Math.min(prevInterval[1], concateList[i][1]);
                res.add(overlap);
            }
            prevInterval = concateList[i];
        }
        
        return res.toArray(new int[res.size()][]);
    }
}