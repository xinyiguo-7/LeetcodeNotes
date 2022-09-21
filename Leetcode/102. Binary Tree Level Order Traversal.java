// Approach: BFS
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // Add nodes of next level to a queue when traversing current level
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            while(size-- > 0) {
                TreeNode curr = q.poll();
                level.add(curr.val);
                if(curr.left != null) {
                    q.add(curr.left);
                }
                if(curr.right != null) {
                    q.add(curr.right);
                }
            }
            res.add(level);
        }
        return res;
    }    
}

// Test Case:
//  3
// 9 20
//  15 7
// res 3
// ----
// q 15 7
// size 0
// level 9 20
// curr 20