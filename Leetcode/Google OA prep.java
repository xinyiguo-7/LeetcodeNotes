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