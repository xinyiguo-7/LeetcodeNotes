// Work on this later
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> wordDict = new HashMap<>();
        int L = beginWord.length();
        
        for(String word : wordList) {
            for(int i = 0; i < L; i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1, L);
                List<String> wordMatches = wordDict.getOrDefault(pattern, new ArrayList<>());
                wordMatches.add(word);
                wordDict.put(pattern, wordMatches);
            }
        }
        
        // Use BFS to find all paths
        Queue<String> wordQ = new LinkedList<>();
        Map<String, List<List<String>>> paths = new HashMap<>();
        Set<String> visited = new HashSet<>();
        List<List<String>> validPath = new ArrayList<>();
        int len = 1, minLen = Integer.MAX_VALUE;
        wordQ.add(beginWord);
        List<List<String>> nll = new ArrayList<>();
        List<String> nl = new ArrayList<>(Arrays.asList(beginWord));
        nll.add(nl);
        paths.put(beginWord, nll);
        visited.add(beginWord);
        
        while(!wordQ.isEmpty()) {
            int size = wordQ.size();
            while(size-- > 0) {
                String curWord = wordQ.poll();
                for(int j = 0; j < L; j++) {
                    String p = curWord.substring(0, j) + "*" + curWord.substring(j + 1, L);
                    if(wordDict.containsKey(p) && paths.containsKey(curWord)) {
                        List<String> mWords = wordDict.get(p);
                        for(String str : mWords) {
                            if(!visited.contains(str)) {
                                wordQ.add(str);
                                // List<String> newPath = new LinkedList<>(paths.get(curWord));
                                for(List<String> newPath : paths.get(curWord)) {
                                    List<String> temp = new ArrayList<>(newPath);
                                    temp.add(str);
                                    if(str.equals(endWord)) {
                                        validPath.add(temp);
                                        minLen = Math.min(minLen, len + 1);
                                    } else {
                                        List<List<String>> nl2 = paths.getOrDefault(str, new ArrayList<>());
                                        nl2.add(temp);
                                        paths.put(str, nl2);
                                        visited.add(str);
                                    }
                                }

                            } 
                        }
                    }
                }
                paths.remove(curWord);
            }
            len++;
        }
        List<List<String>> res = new ArrayList<>();
        for(List<String> path : validPath) {
            if(path.size() == minLen)
                res.add(path);
        }
        return res;
    }
}

class Solution {
    public List<List<String>> findLadders(String b, String e, List<String> wordList) 
    {
        Set<String> words = new HashSet<>(wordList);
        if(!words.contains(e))
            return Collections.emptyList();
        
        Map<String, List<String>> adj = new HashMap<>();
        Deque<String> q = new ArrayDeque<>();
        q.offer(b);
        Set<String> enqueuedWords = new HashSet<>();
        enqueuedWords.add(b);
        while(!q.isEmpty())
        {
            int size = q.size();
            Set<String> removableWords = new HashSet<>();
            for(int i = 0; i < size; i++)
            {
                String cur = q.poll();
                char[] ch = cur.toCharArray();
                for(int j = 0; j < cur.length(); j++)
                {
                    char old = ch[j];
                    for(char c = 'a'; c <= 'z'; c++)
                    {
                        if(c == old)
                            continue;
                        
                        ch[j] = c;
                        String newSt = String.valueOf(ch);
                        if(words.contains(newSt) && !newSt.equals(b))
                        {
                            adj.computeIfAbsent(newSt, e1 -> new ArrayList<>()).add(cur);
                            removableWords.add(newSt);
                            if(!enqueuedWords.contains(newSt))
                            {
                                q.offer(newSt);
                                enqueuedWords.add(newSt);
                            }
                        }
                    }
                    ch[j] = old;
                }
            }
             words.removeAll(removableWords);
        }
        if(!adj.containsKey(e))
            return Collections.emptyList();
       
        List<List<String>> res = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        cur.add(e);
        dfs(adj,res, b, cur, e);
        return res;
    }
    
    void dfs(Map<String, List<String>> adj, List<List<String>> res, String b, List<String> cur, String e)
    {
        if(cur.get(cur.size()-1).equals(b)) {
            List<String> curCp = new ArrayList<>(cur);
            Collections.reverse(curCp);
            res.add(curCp);
            return;
        }
        for(String s : adj.get(e))
        {
            cur.add(s);
            dfs(adj, res, b, cur, s);
            cur.remove(cur.size()-1);
        }
    }
}

class Solution
{
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList)
    {
        LinkedList<String> queue = new LinkedList<>();
        HashSet<String> words = new HashSet<>();
        for(String ele : wordList) words.add(ele);
        HashMap<String ,Integer> size = new HashMap<>();
        size.put(beginWord,0);
        HashMap<String,LinkedList<String>> map = new HashMap<>();
        HashMap<String,LinkedList<String>> newMap = new HashMap<>();
        queue.add(beginWord);
        map.put(beginWord,new LinkedList<>());
        while(queue.size() > 0)
        {
            int s = queue.size();
            while(s-- > 0)
            {
                String pop = queue.removeFirst();
                for(int i = 0;i<pop.length();i++)
                {
                    StringBuilder sb = new StringBuilder(pop);
                    for(int j = 0;j<26;j++)
                    {
                        char ch = (char)('a'+j);
                        sb.setCharAt(i,ch);
                        String temp = sb.toString();
                        if(words.contains(temp))
                        {
                            if(!size.containsKey(temp))
                            {
                                map.put(temp,new LinkedList());
                                map.get(pop).addLast(temp);
                                queue.addLast(temp);
                                size.put(temp,size.get(pop)+1);
                            }
                            else if(size.get(pop)+1 == size.get(temp))
                            {
                                map.get(pop).addLast(temp);
                            }
                        }
                    }
                }
            }
        }
        
        for(String ele : map.keySet())
        {
            for(String e : map.get(ele))
            {
                if(!newMap.containsKey(e)) newMap.put(e,new LinkedList<>());
                newMap.get(e).addLast(ele);
            }
        }
        
        List<List<String>> ans = new ArrayList<>();
        getPaths(newMap,endWord,beginWord,ans,new ArrayList<>());
        return ans;
    }
    
    public void getPaths(HashMap<String,LinkedList<String>> map , String beginWord , String endWord,List<List<String>> ans,List<String> temp)
    {
        if(beginWord.equals(endWord))
        {
            temp.add(beginWord);
            List<String> l = new LinkedList<>();
            for(String ele : temp) l.add(0,ele);
            ans.add(l);
            temp.remove(temp.size()-1);
            return;
        }
        temp.add(beginWord);
        if(!map.containsKey(beginWord)) return;
        for(String ele : map.get(beginWord))
        {
            getPaths(map,ele,endWord,ans,temp);
        }
        temp.remove(temp.size()-1);
    }
}