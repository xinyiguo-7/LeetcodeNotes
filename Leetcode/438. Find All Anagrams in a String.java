// A cleaner solution from LeetCode
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
      int ns = s.length(), np = p.length();
      if (ns < np) return new ArrayList();
  
      int [] pCount = new int[26];
      int [] sCount = new int[26];
      // build reference array using string p
      for (char ch : p.toCharArray()) {
        pCount[(int)(ch - 'a')]++;
      }
  
      List<Integer> output = new ArrayList();
      // sliding window on the string s
      for (int i = 0; i < ns; ++i) {
        // add one more letter 
        // on the right side of the window
        sCount[(int)(s.charAt(i) - 'a')]++;
        // remove one letter 
        // from the left side of the window
        if (i >= np) {
          sCount[(int)(s.charAt(i - np) - 'a')]--;
        }
        // compare array in the sliding window
        // with the reference array
        if (Arrays.equals(pCount, sCount)) {
          output.add(i - np + 1);
        }
      }
      return output;
    }
  }

// Second AC Solution.
// Time Complexity: O(N)
// Space Complexity: O(K) - K is the number of alphabet
// Approach: Sliding window + array
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] sArray = new int[26];
        int[] pArray = new int[26];
        List<Integer> res = new ArrayList<>();
        if(p.length() > s.length()) {
            return res;
        }
        for(int i = 0; i < p.length(); i++) {
            pArray[p.charAt(i) - 'a']++;
        }
        for(int j = 0; j < p.length(); j++) {
            if(pArray[s.charAt(j) - 'a'] != 0) {
                sArray[s.charAt(j) - 'a']++;
            }
        }
        if(Arrays.equals(sArray, pArray))
            res.add(0);
        int begin = 0;
        for(int end = p.length(); end < s.length(); end++) {
            if(sArray[s.charAt(begin) - 'a'] > 0)
                sArray[s.charAt(begin) - 'a']--;
            begin++;
            if(pArray[s.charAt(end) - 'a'] != 0) {
                sArray[s.charAt(end) - 'a']++;
            }
            if(Arrays.equals(sArray, pArray))
                res.add(begin);
        }
        
        return res;
    }
}

// First Trial. Exceeded time limit.
// Time Complexity: O(NlogN)
// Using java builtin function to convert string to charArray,
// sort the array and compare to find anagrams.
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        char[] pChars = p.toCharArray();
        Arrays.sort(pChars);
        String sortedp = String.copyValueOf(pChars);
        List<Integer> res = new ArrayList<>();
        
        int left = 0, right = p.length();
        while(right <= s.length()) {
            char[] subChars = s.substring(left, right).toCharArray();
            Arrays.sort(subChars);
            if(String.copyValueOf(subChars).equals(sortedp)) {
                res.add(left);
            }
            left++;
            right++;
        }
        return res;
    }
}