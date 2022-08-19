// Time Complexity: O(N * N)
// Space Complexity: O(N)
// Approach: Use array list to store seen words, which exceeds time limit
class Solution {
    public int longestPalindrome(String[] words) {
        List<String> seen = new ArrayList<>();
        int len = 0;
        
        for(String str : words) {
            StringBuilder sb = new StringBuilder(str);
            sb.reverse();
            String reversed = sb.toString();
            
            // 
            if(seen.contains(reversed)) { 
                len += 4;
                seen.remove(reversed);
            } else {
                seen.add(str);
            }
        }
        
        for(String str : seen) {
            if(str.charAt(0) == str.charAt(1)) {
                len += 2;
                break;
            }
        }
        return len;
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N)
// Use mapping to speed up searching process.
class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        int len = 0;
        
        for(String str : words) {
            StringBuilder sb = new StringBuilder(str);
            sb.reverse();
            String reversed = sb.toString();
            
            if(map.containsKey(reversed) && map.get(reversed) > 0) {
                len += 4;
                map.put(reversed, map.get(reversed) - 1);
            } else {
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }
        
        // Count number of pairs that have the same 2 characters
        int samePairs = 0;
        for(String str : map.keySet()) {
            if(str.charAt(0) == str.charAt(1)) {
                samePairs = Math.max(samePairs, map.get(str));
            }
        }
        // Add # pairs * 2 to string length
        return len + samePairs * 2;
    }
}