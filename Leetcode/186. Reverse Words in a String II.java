// Approach 1: reverse the whole char array, then reverse the words in between
class Solution {
    public void reverseWords(char[] s) {
        // Reverse the whole s array
        int left = 0, right = s.length - 1;
        reverse(s, left, right);
        
        int start = 0, end = 0;
        while(end <= s.length - 1) {
            if(end == s.length - 1 || s[end + 1] == ' ') {
                reverse(s, start, end);
                start = end + 2;
                end++;
            }
            end++;
        }
    }
    
    public void reverse(char[] s, int left, int right) {
        while(left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}

// Approach: another way of indexing
class Solution {
    public void reverseWords(char[] s) {
        reverseString(s, 0, s.length - 1);
        int start = 0;
        while(start < s.length) {
            int end = start;
            while(end + 1 < s.length && s[end + 1] != ' ') {
                end++;
            }
            reverseString(s, start, end);
            start = end + 2;
        }
    }
    
    public void reverseString(char[] s, int start, int end) {
        while(start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}