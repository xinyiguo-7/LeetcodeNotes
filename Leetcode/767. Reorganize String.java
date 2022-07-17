// Time Complexity: O(N)
// Space Complexity: O(N)
class Solution {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        int N = s.length();
        int count = 0;
        for(int i = 0; i < N; i++) {
            char ch = s.charAt(i);
            count = map.getOrDefault(ch, 0) + 1;
            // If the max count is greater than half of the string length,
            // then a result is not possible.
            if(count > (N + 1) / 2) {
                return "";
            }
            map.put(ch, count);
        }
        
        // int[] (character -> int, count)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for(char c : map.keySet()) {
            pq.add(new int[]{c, map.get(c)});
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            int[] first = pq.poll();
            // Only when current string is empty and char is not the same as previous one,
            // add it to the string.
            if(sb.length() == 0 || first[0] != sb.charAt(sb.length() - 1)) {
                sb.append((char)first[0]);
                first[1]--;
                if(first[1] > 0) {
                    // add back to PriorityQueue
                    pq.add(first);
                }
            } else {
                int[] second = pq.poll();
                sb.append((char)second[0]);
                second[1]--;
                if(second[1] > 0) {
                    pq.add(second);
                }
                pq.add(first);
            }
        }
        return sb.toString();
    }
}