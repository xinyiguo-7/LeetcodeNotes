// Approach 1: Use a HashMap to store the value with corresponding frequency
// then loop through the map and use a heap to find k max freq element  - O(nlogk)
// Approach 2: Sort and count - O(nlogn) - even worse
// If I didn't come up with heap
// Approach 3: Use TreeSet? sorted based on keys. Too complicated
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // First build a HashMap
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        // Then construct the heap
        Queue<Integer> heap = new PriorityQueue<>(  // Pass new Comparator
            (n1, n2) -> map.get(n2) - map.get(n1));
        //  Ex. If map.get(n2) > map.get(n1), return 1, meaning n2 is put in front of 1
        for(int key : map.keySet()) {
            heap.add(key);
        }
        // Build result array
        int[] res = new int[k];
        for(int i = 0; i < k; i++) {
            res[i] = heap.poll();
        }
        return res;
    }
}