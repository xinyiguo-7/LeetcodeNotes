// You are given an array segments consisting of N integers denoting the lengths of several segments. 
// Your task is to find among them four segments from which a rectangle can be constructed. What is 
// the minimum absolute difference between the side lengths of the constructed rectangle?
// Write a function:
// int solution(intl segments); that, given an array segments, returns the minimum absolute difference 
// between the side lengths of the constructed rectangle or -1 if no rectangle can be constructed.
// Examples:
// 1. For segments = [2, 2, 2, 2, 21] we can construct only a 2x2 rectangle out of the given segments. The function should return O.
// 2. For segments = [911, 1, 3, 1000, 1000, 2, 2, 999, 1000, 911], we can construct three rectangles: 2 x 911, 2 x 1000, and 911 x 1000. 
//    Out of those three possibilities, the best one is 911 x 1000. The function should return 89.
// 3. For segments = [4, 1, 1, 1, 3], we cannot construct any rectangle out of the given segments. The function should return -1.

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

// We are given a string text of length N consisting of the letters 'a', 'b' or 'c. 
// We can insert any of those letters before or after any letter in the string.
// The goal is to insert letters into text so that it will follow the pattern "abcabca….. : 
// i.e. it should start with a letter 'a letter 'a' should be followed by 'b', letter "b' 
// should be followed by 'c', and letter 'c' by a. The string may end with any of those three 
// letters. What is the minimum number of letters we need to insert into text?
// Write a function:
// int solution(String text); that, given a string text of length N, returns the minimum number 
// of insertions needed to make text follow the described pattern.
// Examples:
// 1. For text = "aabcc" we need to insert letters 'b' and 'c' between the pair of letters 'a', 
// and then insert letters "a' and 'b' between the two letters 'c'. This way we obtain the string 
// "abcabcabc" and the function should return 4.

// Simulate the sequence checker, if the char is not as expected, insert the expecting char.
public static int solution(String text) {
    char[] chars = text.toCharArray();
    char[] expectedChar = {'a', 'b', 'c'};
    int count = 0;
    int expIdx = 0;
    for(char ch : chars) {
        while(ch != expectedChar[expIdx]) {
            count++;
            expIdx = (expIdx + 1) % 3;
        }
        expIdx = (expIdx + 1) % 3;
    }
    // edge case: if text does not ends with c
    char lastChar = chars[chars.length - 1];
    if(lastChar != 'c') {
        if(lastChar == 'a') {
            count += 2;
        }
        if(lastChar == 'b') {
            count++;
        }
    }
    return count;
}


// Hybrid Maximum
// Given two arrays as:
// An array A of size N
// An array B of size M
// A sequence S is called a Hybrid sequence if it has length N + M and it can be divided into exactly 2 disjoint subsequences A and B.
// Among all the possible hybrid sequences S, determine the maximum value of the expression.
// [Sum of max(S1) max(S2),....max(SN+M)] - [Sum of min(S1),min(S2),.. min(SN+M)]
// Assume indexing is 1 based
// Input:
// N = 2
// A = [4,3]
// M = 2
// B = [1,2]
// Output:
// 9
// The hybrid sequence S = [4,1,2,3] gives the maximum value
// Explanation:
// [4,1,2,3] -> [max(4)+max(4,1)+max(4,1,2)+max(4,1,2,3)]-[min(4)+min(4,1)+min(4,1,2)+min(4,1,2,3)] = 16-7 = 9
// Find all possible subsequences of S, then sum(maxs) - sum(mins)

public static int solution(int N, int[] A, int M, int[] B) {
    int[][] Sa = new int[N + 1][];
    int[][] Sb = new int[M + 1][];
    for(int i = 0; i <= N; i++) {
        Sa[i] = new int[]{0, Integer.MAX_VALUE};
    }
    for(int j = 0; j <= M; j++) {
        Sb[j] = new int[]{0, Integer.MAX_VALUE};
    }

    for(int k = 1; k <= N; k++) {
        Sa[k][0] = Math.max(Sa[k - 1][0], A[k - 1]);
        Sa[k][1] = Math.min(Sa[k - 1][1], A[k - 1]);
    }
    for(int l = 1; l <= M; l++) {
        Sb[l][0] = Math.max(Sb[l - 1][0], B[l - 1]);
        Sb[l][1] = Math.min(Sb[l - 1][1], B[l - 1]);
    }
    int[][] dp = new int[N + 1][M + 1];
    for(int i = 0; i <= N; i++) {
        for(int j = 0; j <= M; j++) {
            if(i != N) {
                dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j] + Math.max(Sa[i+1][0], Sb[j][0]) - Math.min(Sa[i+1][1], Sb[j][1]));
            }
            if(j != M) {
                dp[i][j+1] = Math.max(dp[i][j+1], dp[i][j] + Math.max(Sa[i][0], Sb[j+1][0]) - Math.min(Sa[i][1], Sb[j+1][1]));
            }
        }
    }
    return dp[N][M];
}

// One fragment of a given integer N can be selected and its digits reversed (replaced with a right to left 
// version of themselves). What is the maximum number that can beobtained this way from integer N?
// Write a function:
// class Solution { public int solution(int N); }
// that, given an integer 1 <= N <= 1,000,000,000, returns the greatest integer that can be created by reversing a subset of its digits.
// Examples:
// • Given N = 5340, [he answer is 5430. Fragment "34" can be reversed to "43".
// • Given N = 2043, the answer is 4023. Fragment "204" can be reversed to "402"
// • Given N = 620, the answer is 620. There is no need to reverse any fragment.

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

// Pick 3 digits from N to form the maximum integer
public static int solution(int N) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    while(N != 0) {
        pq.add(N % 10);
        N /= 10;
    }
    int res = 0;
    for(int i = 2; i >= 0; i--) {
        int mult = (int)Math.pow(10, i);
        res += pq.poll() * mult;
    }
    return res;
}

// Do the two words rhyme?
