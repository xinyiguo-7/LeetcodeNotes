// Time Complexity: O(NlogN) - Arrays.sort()
// Space Complexity: O(N) - Length of the array
class Solution {
    public String largestNumber(int[] nums) {
        // Comparator is an abstract class, so we need to specify object type in <>
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String order1 = s1 + s2;
                String order2 = s2 + s1;
                // Sort by the value of s1 before s2/s2 before s1 in descending order
                return order2.compareTo(order1);
            }
        };
        
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        // Sort the string array using new comparator
        Arrays.sort(strs, comp);
        // Edge case: if all values in strs are "0", then we only return "0"
        if(strs[0].charAt(0) == '0') {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            sb.append(s);
        }
        return sb.toString();
    }
}