// Approach 1: HashMap
// Time Complexity: O(M+N)
// Space Complexity: O(max(M, N))
// Use a HashMap to store each elem in nums1 as key
// and their count as value
// Loop through nums2, if elems still remain in hashmap,
// add to the resulting array
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> lst = new ArrayList<>();
        
        for(int n1 : nums1) {
            map.put(n1, map.getOrDefault(n1, 0) + 1);
        }
        
        for(int n2 : nums2) {
            if(map.containsKey(n2)) {
                lst.add(n2);
                map.put(n2, map.get(n2) - 1);
                
                if(map.get(n2) == 0) {
                    map.remove(n2);
                }
            }
        }
        // converting List<Integer> to int[] array
        int[] res = lst.stream().mapToInt(i -> i).toArray();
        return res;
    }
}

// Approach 2: Sorting
// Sort two arrays, loop together
// If same element occurs, increment both indexes
// If one is smaller than the other, increment
// index of the small one
// Time Complexity: O(max(NlogN, MlogM))
// Space Complexity: O(min(M, N))
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> lst = new ArrayList<>();
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i1 = 0, i2 = 0;
        int N1 = nums1.length, N2 = nums2.length;
        while(i1 < N1 && i2 < N2) {
            if(nums1[i1] == nums2[i2]) {
                lst.add(nums1[i1]);
                i1++;
                i2++;
            } else if(nums1[i1] < nums2[i2]) {
                i1++;
            } else {
                i2++;
            }
        }
        int[] res = lst.stream().mapToInt(i -> i).toArray();
        return res;
    }
}