// Approach: BFS
// Time Complexity: O(M^2 *N)
// Space Complexity: O(M^2 * N)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Preprocessing: construct a undirected graph using wordList
        // Key: Pattern A*BC, Value: list of words that match this pattern
        int L = beginWord.length();
        Map<String, List<String>> wordDict = new HashMap<>();
        
        for(String word : wordList) {
            for(int i = 0; i < L; i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1, L);
                List<String> combinations = wordDict.getOrDefault(pattern, new ArrayList<>());
                combinations.add(word);
                wordDict.put(pattern, combinations);
            }
        }
        
        Queue<String> q = new LinkedList<>();
        Map<String, Boolean> visited = new HashMap<>();
        q.add(beginWord);
        visited.put(beginWord, true);
        
        int len = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                size--;
                String curWord = q.poll();
                for(int i = 0; i < L; i++) {
                    String pattern = curWord.substring(0, i) + "*" + curWord.substring(i + 1, L);
                    if(wordDict.containsKey(pattern)) {
                        List<String> nextLadder = wordDict.get(pattern);
                        for(String str : nextLadder) {
                            if(endWord.equals(str)) {
                                return len + 1;
                            } else if (!visited.containsKey(str)){
                                q.add(str);
                                visited.put(str, true);
                            }
                        }
                    }
                }
            }
            len++;
        }
        return 0;
        
    }
}