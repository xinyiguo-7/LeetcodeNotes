import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Collections;

// One fragment of a given integer N can be selected and its digits reversed (replaced with a right to left 
// version of themselves). What is the maximum number that can beobtained this way from integer N?
// Write a function:
// class Solution { public int solution(int N); }
// that, given an integer 1 <= N <= 1,000,000,000, returns the greatest integer that can be created by reversing a subset of its digits.
// Examples:
// • Given N = 5340, [he answer is 5430. Fragment "34" can be reversed to "43".
// • Given N = 2043, the answer is 4023. Fragment "204" can be reversed to "402"
// • Given N = 620, the answer is 620. There is no need to reverse any fragment.
public class Google_OA_testing {

    public static int solution(int N) {
        String strN = Integer.toString(N);
        char[] charN = strN.toCharArray();
        int r = 0, l = 0;
        int len = strN.length();
        
        for(int i = 1; i < charN.length; i++) {
            if(Integer.valueOf(charN[i]) > Integer.valueOf(charN[i - 1])) {
                r = i;
            }
        }
        for(int j = 0; j < charN.length; j++) {
            if(Integer.valueOf(charN[j]) < Integer.valueOf(charN[r])) {
                l = j;
                break;
            }
        }
        // System.out.println("r: " + r + ", l: " + l);
        StringBuilder reversedSb = new StringBuilder(strN.substring(l, r + 1));
        String reversed = reversedSb.reverse().toString();
        // System.out.println("Reversed: " + reversed);
        return Integer.valueOf(strN.substring(0, l) + reversed + strN.substring(r + 1, len));
    }

    public static void main(String[] args) {
        int N1 = 5340;
        System.out.println("N1: " + N1);
        System.out.println(solution(N1));

        int N2 = 2043;
        System.out.println("N2: " + N2);
        System.out.println(solution(N2));

        int N3 = 620;
        System.out.println("N3: " + N3);
        System.out.println(solution(N3));
    }
}