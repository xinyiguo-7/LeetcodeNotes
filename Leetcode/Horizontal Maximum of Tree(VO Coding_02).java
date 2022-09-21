import java.util.HashMap;

class Solution {
    HashMap<Integer, Integer> map;
    public List<Integer> horizontalMaxOfTree(TreeNode root) {
        map = new HashMap<>();    // Store column index - max
        dfs(0, root, map);
        return map.values();
    }

    public void dfs(int col, TreeNode curr, HashMap<Integer, Integer> map) {
        if(curr == null) {
            return;
        }
        if(!map.containsKey(col)) {
            map.put(col, curr.val);
        } else {
            map.put(col, Math.max(curr.val, map.get(col)));
        }
        dfs(col - 1, curr.left, map);
        dfs(col + 1, curr.right, map);
    }
}