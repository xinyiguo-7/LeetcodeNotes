// Time Complexity: O(N^2 / k)
// Space Complexity: O(1)
// Approach: Brute Force. Iterate each time I find and delete a duplicate substring
class Solution {
    public String removeDuplicates(String s, int k) {
        int length = 0;
        StringBuilder sb = new StringBuilder(s);
        
        while(length != sb.length()) {
            // Update length to current str length
            length = sb.length();
            for(int i = 0, count = 1; i < sb.length(); i++) {
                if(i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                    count = 1;
                } else {
                    count++;
                    // If found k string, delete it
                    if(count == k) {
                        // delete(int i, int j + 1)
                        sb.delete(i - k + 1, i + 1);
                        break;
                    }
                }
            }
        }
        return sb.toString();
    }
}

// Approach: Momorize count. If we keep track of character count,
// we don't have to iterate them again
// Time Complexity: O(N)
// Space Complexity: O(N)
class Solution {
    public String removeDuplicates(String s, int k) {
        int N = s.length();
        int[] count = new int[N];
        StringBuilder sb = new StringBuilder(s);
        
        for(int i = 0; i < sb.length(); i++) {
            if(i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                count[i] = 1;
            } else {
                count[i] = count[i - 1] + 1;
                if(count[i] == k) {
                    sb.delete(i - k + 1, i + 1);
                    // move i back to where it's started
                    i = i - k;
                }
            }
        }
        return sb.toString();
    }
}