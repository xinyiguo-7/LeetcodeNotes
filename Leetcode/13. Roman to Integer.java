// Time Complexity: O(1)  - for finite roman numbers
// Space Complexity: O(1)
// My solution using hashmap 
class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        if(s.length() == 1) {
            return map.get(s.charAt(0));
        }
        int res = 0;
        int first = 0, second = 0;
        for(int i = 1; i < s.length(); i++) {
            // Read two characters at a time
            first = map.get(s.charAt(i - 1));
            second = map.get(s.charAt(i));
            
            if(first >= second) {
                res += first;
            } else {
                res += second - first;
                i++;
            }
        }
        // Handle the edge cases: one smaller character left at the end
        first = map.get(s.charAt(s.length() - 2));
        second = map.get(s.charAt(s.length() - 1));
        if(first >= second) {
            res += second;
        }
        return res;
    }
}