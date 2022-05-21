// My Two Pointer Solution
// Time complexity: O(M + N) - length of s + length of t
// Space complexity: O(1)
class Solution {
    public boolean backspaceCompare(String s, String t) {
        int idx1 = s.length() - 1, idx2 = t.length() - 1;
        int bsNum1 = 0, bsNum2 = 0;
        
        while(idx1 >= 0 || idx2 >= 0) {
            if(idx1 >= 0 && s.charAt(idx1) == '#') {
                while(idx1 >= 0 && s.charAt(idx1) == '#') {
                    bsNum1++;
                    idx1--;
                }
                while(bsNum1 > 0 && idx1 >= 0 && s.charAt(idx1) != '#') {
                    idx1--;
                    bsNum1--;
                }
                continue;
            }
            
            if(idx2 >= 0 && t.charAt(idx2) == '#') {
                while(idx2 >= 0 && t.charAt(idx2) == '#') {
                    bsNum2++;
                    idx2--;
                }
                while(bsNum2 > 0 && idx2 >= 0 && t.charAt(idx2) != '#') {
                    bsNum2--;
                    idx2--;
                }
                continue;
            }
            if(idx1 < 0 || idx2 < 0) {
                return false;
            }
            
            if(s.charAt(idx1) != t.charAt(idx2)) {
                return false;
            }
            idx1--;
            idx2--;
        }
        return true;
    }
}

// A much cleaner solution

class Solution {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
            while (i >= 0) { // Find position of next possible char in build(S)
                if (S.charAt(i) == '#') {skipS++; i--;}
                else if (skipS > 0) {skipS--; i--;}
                else break;
            }
            while (j >= 0) { // Find position of next possible char in build(T)
                if (T.charAt(j) == '#') {skipT++; j--;}
                else if (skipT > 0) {skipT--; j--;}
                else break;
            }
            // If two actual characters are different
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
                return false;
            // If expecting to compare char vs nothing
            if ((i >= 0) != (j >= 0))
                return false;
            i--; j--;
        }
        return true;
    }
}

// Updated on 05/20/2022.
// Time Complexity: O(M + N)
// Space Complexity: O(M + N)
// Approach: Use string builder. Easier to implement than Two Pointers method.
class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '#') {
                if(sb1.length() != 0) {
                    sb1.deleteCharAt(sb1.length() - 1);
                }
            } else {
                sb1.append(s.charAt(i));
            }
        }
        
        for(int j = 0; j < t.length(); j++) {
            if(t.charAt(j) == '#') {
                if(sb2.length() != 0) {
                    sb2.deleteCharAt(sb2.length() - 1);
                }
            } else {
                sb2.append(t.charAt(j));
            }
        }
        
        // Have to compare string instead of string builder directly
        return sb1.toString().equals(sb2.toString());
    }
}