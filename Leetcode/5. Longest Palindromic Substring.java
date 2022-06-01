// Time Complexity: O(N ^ 2)
// Space Complexity: O(N ^ 2)
// Approach: Dynamic Programming
class Solution {
    private int maxLength = 1;
    private int[] index = new int[]{0, 0};
    
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        // Loop through String s
        for(int i = 1; i < s.length(); i++) {
            // Consider two cases: 1. a palindrome that has one character in the middle
            // 2. two characters in the middle
            // If within range and is palindrome, start to find start and end index of this palindrome
            start = i - 1;
            end = i + 1;
            if(start >= 0 && end < s.length() 
                  && s.charAt(start) == s.charAt(end)) {
                findPalindrome(s, start, end);
            }
            start = i - 1;
            end = i;
            if(start >= 0 && end < s.length() 
                  && s.charAt(start) == s.charAt(end)) {
                findPalindrome(s, start, end);
            }
        }
        
        return s.substring(index[0], index[1] + 1);  
    }
    
    public void findPalindrome(String s, int start, int end) {
        
        while(start >= 0 && end < s.length()
              && s.charAt(start) == s.charAt(end)) {
                start--;
                end++;
        }
        if(end - start - 1 > maxLength) {
            index[0] = start + 1;
            index[1] = end - 1;
            maxLength = end - start - 1;
        }
    }

}

// A cleaner solution that uses the same method
class Solution {
    int maxlen = 0, start = 0;
    
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            // if substring is odd length
            extendPalindrome(s, i, i);
            // if substring is even length
            extendPalindrome(s, i, i + 1);
        }
        return s.substring(start, start + maxlen);
    }
    
    public void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxlen < k - j - 1) {
            start = j + 1;
            maxlen = k - j - 1;
        }
    }
}