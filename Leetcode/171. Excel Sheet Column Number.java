// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public int titleToNumber(String columnTitle) {
        int N = columnTitle.length();
        int num = columnTitle.charAt(0) - 'A' + 1;
        int i = 1;
        while(i < N) {
            num = num * 26 + columnTitle.charAt(i) - 'A' + 1;
            i++;
        }
        return num;
    }
}