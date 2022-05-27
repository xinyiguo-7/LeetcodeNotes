// Approach: Two Hash Maps
// Time Complexity: O(N)
// Space Complexity: O(N)
// There must exist a bijection between pattern and string s.
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        HashMap<Character, String> PtoS = new HashMap<>();
        HashMap<String, Character> StoP = new HashMap<>();
        
        if(pattern.length() != words.length) {
            return false;
        }
        for(int i = 0; i < pattern.length(); i++) {
            if(!PtoS.containsKey(pattern.charAt(i))) {
                PtoS.put(pattern.charAt(i), words[i]);
                
                if(!StoP.containsKey(words[i])) {
                    StoP.put(words[i], pattern.charAt(i));
                } else {
                    return false;
                }
            } else {
                if(!PtoS.get(pattern.charAt(i)).equals(words[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}