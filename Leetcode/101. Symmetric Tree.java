// Time Complexity: O(N)
// Space Complexity: O(N)
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        LinkedList<TreeNode> level = new LinkedList<>();
        level.add(root.left);
        level.add(root.right);
        
        while(!level.isEmpty()) {
            LinkedList<TreeNode> nextLevel = new LinkedList<>();
            while(!level.isEmpty()) {
                TreeNode left = level.removeFirst();
                TreeNode right = level.removeLast();
                if(left == null || right == null) {
                    if(left != null || right != null) {
                        return false;
                    }
                } else {
                    if(left.val != right.val) {
                        return false;
                    }
                    if(left.left != null || left.right != null || right.left != null || right.right != null) {
                        nextLevel.addFirst(left.right);
                        nextLevel.addFirst(left.left);
                        nextLevel.addLast(right.left);
                        nextLevel.addLast(right.right);
                    }
                }
            }
            level = nextLevel;
        }
        return true;
    }
}

// Leetcode solution, same time and space complexity
public boolean isSymmetric(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    q.add(root);
    while (!q.isEmpty()) {
        TreeNode t1 = q.poll();
        TreeNode t2 = q.poll();
        // A cleaner way to deal with null nodes
        // If not both null, then there is no null or one of them is null
        if (t1 == null && t2 == null) continue;
        // If one of them is null, not symmetric
        if (t1 == null || t2 == null) return false;
        // If no null, check value
        if (t1.val != t2.val) return false;
        q.add(t1.left);
        q.add(t2.right);
        q.add(t1.right);
        q.add(t2.left);
    }
    return true;
}