// Time Complexity: O(N * KlogK) - N: length of strs array. K: length of max len string
// Space Complexity: O(NK)
// Approach: Categorize by sorted string.
// Store strs as list by sorted keys into a map, then add the map values (lists of strings) to final result list.
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        
        for(String s : strs) {
            char[] sArray = s.toCharArray();
            Arrays.sort(sArray);
            String sortedS = String.valueOf(sArray);
            
            if(map.containsKey(sortedS)) {
                map.get(sortedS).add(s);
            } else{
                List<String> newList = new ArrayList<>();
                newList.add(s);
                map.put(sortedS, newList);
            }
        }
        for(List<String> group : map.values()) {
            res.add(group);
        }
        return res;
    }
}