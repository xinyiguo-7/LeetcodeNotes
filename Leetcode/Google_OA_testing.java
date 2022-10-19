import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Collections;

public class Google_OA_prep {
    // Count the number of occurrences for each segments
    // If there is a segment occurred >= 4 times, return 0
    // Count the number of segments that occurred 2 or 3 times, if the number is < 2, return -1
    // Sort the segments occurred 2 or 3 times, return the min difference between 2 adjacent ones
    public static int solution(int[] segments) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : segments) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        System.out.println(map.toString());
        List<Integer> twoOrThree = new ArrayList<>();
        for(int key : map.keySet()) {
            int freq = map.get(key);
            if(freq >= 4) {
                return 0;
            }
            // occurrences[map.get(key)]++;
            if(freq == 2 || freq == 3) {
                twoOrThree.add(key);
            }
        }
        if(twoOrThree.size() < 2) {
            return -1;
        }
        Collections.sort(twoOrThree);
        int minDiff = twoOrThree.get(twoOrThree.size() - 1) - twoOrThree.get(0);
        for(int i = 1; i < twoOrThree.size(); i++) {
            minDiff = Math.min(minDiff, twoOrThree.get(i) - twoOrThree.get(i - 1));
        }
        return minDiff;
    }

    public static void main(String[] args) {
        // System.out.println("Hello!");
        int[] arr1 = {2, 2, 2, 2, 21};
        System.out.println("Array: [2, 2, 2, 2, 21]");
        System.out.println(solution(arr1));

        int[] arr2 = {911, 1, 3, 1000, 1000, 2, 2, 999, 1000, 911};
        System.out.println("Array: [911, 1, 3, 1000, 1000, 2, 2, 999, 1000, 911]");
        System.out.println(solution(arr2));

        int[] arr3 = {4, 1, 1, 1, 3};
        System.out.println("Array: [4, 1, 1, 1, 3]");
        System.out.println(solution(arr3));
    }
}