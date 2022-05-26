// My AC solution using HashMap.
// Time Complexity: O(N)
// Space Complexity: O(N)
class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int length = 0;
        int single = 0;
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        for(int num : map.values()) {
            if(num % 2 == 0) {
                length += num;
            } else if(num > 1) {
                length += num - 1;
                single = 1;
            } else if(num == 1){
                single = 1;
            }
        }
        length += single;
        return length;
    }
}

// A faster solution also using less space from LeetCode solution
// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c: s.toCharArray())
            count[c]++;

        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            if (ans % 2 == 0 && v % 2 == 1)
                ans++;
        }
        return ans;
    }
}