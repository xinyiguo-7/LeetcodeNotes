// Time Complexity: O(N)
// Space Complexity: O(N)
// Approach: Use a map to store the index of the last appearance of each character,
// then loop through the string again to find the approprate index for partition.
class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] endIdx = new int[26];     // character -> end index
        Arrays.fill(endIdx, -1);
        for(int i = 0; i < s.length(); i++) {
            endIdx[s.charAt(i) - 'a'] = i;
        }
        int i = 0;
        int end = endIdx[s.charAt(0) - 'a'];
        int prevEnd = 0;
        List<Integer> partition = new ArrayList<>();
        while(i < s.length()) {
            end = end > endIdx[s.charAt(i) - 'a'] ? end : endIdx[s.charAt(i) - 'a'];
            if(i == end) {
                partition.add(i + 1 - prevEnd);
                prevEnd = i + 1;
            }
            i++;
        }
        return partition;
    }
}