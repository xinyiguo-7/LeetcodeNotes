import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.*;;

// Do the two words rhyme?
public class Google_OA_testing {

    public static boolean solution(String s) {
        String[] words = s.split("-");
        String word1 = words[0];
        int idx1 = word1.length() - 1;
        String word2 = words[1];
        int idx2 = word2.length() - 1;

        int count = 3;
        while(count > 0 && idx1 >= 0 && idx2 >= 0) {
            if(word1.charAt(idx1) != word2.charAt(idx2)) {
                return false;
            }
            idx1--;
            idx2--;
            count--;
        }
        return count > 0 ? false : true;
    }

    public static void main(String[] args) {
        // String S1 = "news-views";
        // System.out.println("S1: " + S1);
        // System.out.println(solution(S1));

        // String S2 = "at-cat";
        // System.out.println("S2: " + S2);
        // System.out.println(solution(S2));

        // String S3 = "football-allal";
        // System.out.println("S3: " + S3);
        // System.out.println(solution(S3));

        // String S4 = "-pet";
        // System.out.println("S4: " + S4);
        // System.out.println(solution(S4));
        List<Character> lockList = new ArrayList<>();
        // lockList.add(1);
        lockList.remove((char)'a');
    }
}