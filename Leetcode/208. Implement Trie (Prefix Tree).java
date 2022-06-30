class TrieNode {
    
  private TrieNode[] links;
  private final int SIZE = 26;
  private boolean isEnd;
  
  public TrieNode() {
      links = new TrieNode[SIZE];
  }
  
  public boolean containsKey(char ch) {
      return links[ch - 'a'] != null;
  }
  public TrieNode get(char ch) {
      return links[ch - 'a'];
  }
  public void put(char ch, TrieNode node) {
      links[ch - 'a'] = node;
  }
  public void setEnd() {
      isEnd = true;
  }
  public boolean isEnd() {
      return isEnd;
  }
}
class Trie {
  TrieNode root;
  
  public Trie() {
      root = new TrieNode();
  }
  
  public void insert(String word) {
      TrieNode node = root;
      for(int i = 0; i < word.length(); i++) {
          char currCh = word.charAt(i);
          if(node.containsKey(currCh)) {
              node = node.get(currCh);
          } else {
              TrieNode newNode = new TrieNode();
              node.put(currCh, newNode);
              node = node.get(currCh);
          }
      }
      node.setEnd();
  }
  
  public boolean search(String word) {
      TrieNode node = root;
      for(int i = 0; i < word.length(); i++) {
          if(node != null && node.containsKey(word.charAt(i))) {
              node = node.get(word.charAt(i));
          } else {
              return false;
          }
      }
      return node.isEnd() ? true : false;
  }
  
  public boolean startsWith(String prefix) {
      TrieNode node = root;
      for(int i = 0; i < prefix.length(); i++) {
          if(node != null && node.containsKey(prefix.charAt(i))) {
              node = node.get(prefix.charAt(i));
          } else {
              return false;
          }
      }
      return true;
  }
}

/**
* Your Trie object will be instantiated and called as such:
* Trie obj = new Trie();
* obj.insert(word);
* boolean param_2 = obj.search(word);
* boolean param_3 = obj.startsWith(prefix);
*/