// Time Complexity: O(N)
// Space Complexity: O(1)
// Approach: use Java indexOf()
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle == "") {
            return 0;
        }
        return haystack.indexOf(needle);
    }
}