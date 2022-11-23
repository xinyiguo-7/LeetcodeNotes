// Approach: Depth-First Search, recursive
// Time Complexity: O(N)
// Space Complexity: O(N)
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N)
// Approach: DFS
class Solution {
    public TreeNode invertTree(TreeNode root) {
        return invert(root);
    }
    
    // inverts children and returns itself
    public TreeNode invert(TreeNode node) {
        if(node == null) {
            return null;
        }
        TreeNode left = invert(node.left);
        TreeNode right = invert(node.right);
        node.left = right;
        node.right = left;
        return node;
    }
}