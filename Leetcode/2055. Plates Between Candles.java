// Brute Force: loop through each substring and count the numbers
// Will exceeds time limit
class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int N = queries.length;
        int[] answer = new int[N];
        for(int i = 0; i < N; i++) {
            int[] q = queries[i];
            boolean hasCandle = false;
            int j = q[0];
            int count = 0;
            while(j <= q[1]) {
                if(s.charAt(j) == '*') {
                    count++;
                } else if(s.charAt(j) == '|') {
                    if(hasCandle) {
                        answer[i] += count;
                    }
                    count = 0;
                    hasCandle = true;
                }
                j++;
            }
        }
        return answer;
    }
}

// Prefix Sum + Binary Search
// N:= length of string, M:= length of queries, K:= number of candles
// Time Complexity: O(N) + O(M*KlogK) = O(N + M*KlogK)
// Space Complexity: O(N + M)
class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int[] ans = new int[queries.length];
        int N = s.length();
        // Mark the candle indexes for binary search
        List<Integer> candles = new ArrayList<>();
        // Use difference of prefix sum to get number of plates
        int[] prefixSum = new int[N];
        boolean hasCandle = false;
        
        int end = N - 1;
        for(int j = N - 1; j >= 0; j--) {
            if(s.charAt(j) =='|') {
                end = j;
                break;
            }
        }
        // stop on the last candle to avoid adding plates after the last candle
        for(int i = 0; i <= end; i++) {
            if(s.charAt(i) == '|') {
                candles.add(i);
                prefixSum[i] = i - 1 >= 0 ? prefixSum[i - 1] : 0;
                hasCandle = true;
            } else {
                if(hasCandle) {
                    // prefixSum[i] = i - 1 >= 0 ? prefixSum[i - 1] + 1 : 0;
                    prefixSum[i] = prefixSum[i - 1] + 1;
                }
            }
        }
        
        int k = 0;
        for(int[] q : queries) {
            // Find the candle indexes
            int first = binarySearch(candles, q[0]); // return candle index
            int last = binarySearch(candles, q[1]);
            if(first >= candles.size()) {
                first--;
            }
                                        // The index is larger than target
                                        // --> decrease index of candle list to avoid adding plates not between candles 
            if(last >= candles.size() || candles.get(last) > q[1]) {
                last--;
            }
            if(last < 0) last = 0;
            if(!candles.isEmpty()) ans[k] = prefixSum[candles.get(last)] - prefixSum[candles.get(first)];
            if(ans[k] < 0) ans[k] = 0;
            k++;
        }
        return ans;
    }
    
    // Find the rightmost candle index larger than target
    public int binarySearch(List<Integer> ls, int target){
        int l = 0;
        int h = ls.size();
        
        
        while(l<h){
            int m = l + (h-l)/2; 
            if(ls.get(m) < target){
                l = m + 1;
            }else{
                h = m;
            }
        }
        return l;
    }
}