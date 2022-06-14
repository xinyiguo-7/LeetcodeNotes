// My revised BFS solution. For this question, traversing level by level gives a correct
// order for nodes on the same column.
// Time Complexity: O(NlogN)
// Space Complexity: O(N)
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if(root == null) {
            return res;
        }
        
        Queue<Pair<TreeNode, Integer>> Q = new LinkedList<>();
        int col = 0;
        // use a variable to record the left baseline, so the real column index is col + left
        int left = 0;
        Q.add(new Pair(root, col));
        
        while(!Q.isEmpty()) {
            Pair<TreeNode, Integer> p = Q.poll();
            TreeNode curr = p.getKey();
            col = p.getValue();
            
            if(curr != null) {
                if(col + left >= res.size()) {
                    res.add(new ArrayList<Integer>());
                    res.get(col + left).add(curr.val);
                } else if(col + left < 0) {
                    res.addFirst(new ArrayList<Integer>());
                    res.get(0).add(curr.val);
                    // Found a new left column, increase left
                    left++;
                } else {
                    res.get(col + left).add(curr.val);
                }
                Q.add(new Pair(curr.left, col - 1));
                Q.add(new Pair(curr.right, col + 1));
            }
        }
        return res;
    }
}

// Leetcode solution
// Approach: BFS
// Time Complexity: O(NlogN)
// Space Complexity: O(N)
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
      List<List<Integer>> output = new ArrayList();
      if (root == null) {
        return output;
      }
  
      Map<Integer, ArrayList> columnTable = new HashMap();
      Queue<Pair<TreeNode, Integer>> queue = new ArrayDeque();
      int column = 0;
      queue.offer(new Pair(root, column));
  
      while (!queue.isEmpty()) {
        Pair<TreeNode, Integer> p = queue.poll();
        root = p.getKey();
        column = p.getValue();
  
        if (root != null) {
          if (!columnTable.containsKey(column)) {
            columnTable.put(column, new ArrayList<Integer>());
          }
          columnTable.get(column).add(root.val);
  
          queue.offer(new Pair(root.left, column - 1));
          queue.offer(new Pair(root.right, column + 1));
        }
      }
  
      List<Integer> sortedKeys = new ArrayList<Integer>(columnTable.keySet());
      Collections.sort(sortedKeys);
      for(int k : sortedKeys) {
        output.add(columnTable.get(k));
      }
  
      return output;
    }
}

// Approach: DFS
// Time Complexity: O(W * HlogH)
// Space Complexity: O(N)
class Solution {
    Map<Integer, ArrayList<Pair<Integer, Integer>>> columnTable = new HashMap();
    int minColumn = 0, maxColumn = 0;
  
    private void DFS(TreeNode node, Integer row, Integer column) {
      if (node == null)
        return;
  
      if (!columnTable.containsKey(column)) {
        this.columnTable.put(column, new ArrayList<Pair<Integer, Integer>>());
      }
  
      this.columnTable.get(column).add(new Pair<Integer, Integer>(row, node.val));
      this.minColumn = Math.min(minColumn, column);
      this.maxColumn = Math.max(maxColumn, column);
      // preorder DFS traversal
      this.DFS(node.left, row + 1, column - 1);
      this.DFS(node.right, row + 1, column + 1);
    }
  
    public List<List<Integer>> verticalOrder(TreeNode root) {
      List<List<Integer>> output = new ArrayList();
      if (root == null) {
        return output;
      }
  
      this.DFS(root, 0, 0);
  
      // Retrieve the resuts, by ordering by column and sorting by row
      for (int i = minColumn; i < maxColumn + 1; ++i) {
  
        Collections.sort(columnTable.get(i), new Comparator<Pair<Integer, Integer>>() {
          @Override
          public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
            return p1.getKey() - p2.getKey();
          }
        });
  
        List<Integer> sortedColumn = new ArrayList();
        for (Pair<Integer, Integer> p : columnTable.get(i)) {
          sortedColumn.add(p.getValue());
        }
        output.add(sortedColumn);
      }
  
      return output;
    }
  }