// Approach: BFS
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> ll = new LinkedList<>();
        if(root == null) {
            return res;
        }
        ll.add(root);
        boolean even = true;
        
        while(!ll.isEmpty()) {
            LinkedList<TreeNode> nextll = new LinkedList<>();
            List<Integer> level = new ArrayList<>();
            while(!ll.isEmpty()) {
                if(even) {
                    TreeNode curr = ll.removeFirst();
                    level.add(curr.val);
                    if(curr.left != null) {
                        nextll.add(curr.left);
                    }
                    if(curr.right != null) {
                        nextll.add(curr.right);
                    }
                }
                if(!even) {
                    TreeNode curr = ll.removeLast();
                    level.add(curr.val);
                    if(curr.right != null) {
                        nextll.addFirst(curr.right);
                    }
                    if(curr.left != null) {
                        nextll.addFirst(curr.left);
                    }
                }
            }
            ll = nextll;
            even = !even;
            res.add(level);
        }
        return res;
    }
}