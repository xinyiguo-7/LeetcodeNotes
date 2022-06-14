// Time Complexity: O(N ^ 2)
// Space Complexity: O(N)
class Solution {
  public String longestCommonPrefix(String[] strs) {
      if(strs.length == 0) {
          return "";
      }
      if(strs.length == 1) {
          return strs[0];
      }
      StringBuilder prefix = new StringBuilder();
      String prevStr = strs[0];
      String currStr = strs[1];
      
      for(int i = 0; i < Math.min(prevStr.length(), currStr.length()); i++) {
          if(prevStr.charAt(i) == currStr.charAt(i)) {
              prefix.append(prevStr.charAt(i));
          } else {
              break;
          }
      }
      
      StringBuilder res = prefix;
      for(int j = 2; j < strs.length; j++) {
          currStr = strs[j];
          res = new StringBuilder();
          for(int k = 0; k < prefix.length(); k++) {
              if(k < currStr.length() && currStr.charAt(k) == prefix.charAt(k)) {
                  res.append(currStr.charAt(k));
              } else {
                  break;
              }
          }
          prefix = res;
      }
      return res.toString();
  }
}

// Leetcode solution
// Approach: Horizontal scanning
class Solution {
  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) return "";
    String prefix = strs[0];
    for (int i = 1; i < strs.length; i++)
        // find index of substring prefix, if index == 0, don't change prefix
        // while index != 0, shorten the prefix by one character at the end
        while (strs[i].indexOf(prefix) != 0) {
            prefix = prefix.substring(0, prefix.length() - 1);
            if (prefix.isEmpty()) return "";
        }        
    return prefix;
  }
}
