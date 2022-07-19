// Time Complexity: O(N)
// Space Complexity: O(N)
class Solution {
    public String breakPalindrome(String palindrome) {
        int N = palindrome.length();
        if(N == 1) {
            return "";
        }
        int left = 0, right = N - 1;
        char[] pArray = palindrome.toCharArray();
        
        while(left < right) {
            if(palindrome.charAt(left) != 'a') {
                pArray[left] = 'a';
                return String.valueOf(pArray);
            }
            left++;
            right--;
        }
        pArray[N - 1] = 'b';
        return String.valueOf(pArray);
    }
}