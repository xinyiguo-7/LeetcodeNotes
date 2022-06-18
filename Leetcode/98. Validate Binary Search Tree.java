// Approach: DFS
// Time Complexity: O(N)
// Space Complexity: O(N)
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        // Integer.MAX/MIN_VALUE doesn't work because they can be in edge cases, better set it to null
        return dfs(root.left, null, root.val) && dfs(root.right, root.val, null);
    }
    
    // Use Integer instead of int to catch null
    public boolean dfs(TreeNode currNode, Integer min, Integer max) {
        if(currNode == null) {
            return true;
        }
        // Set min and max boundaries for value
        if((min != null && currNode.val <= min) || (max != null && currNode.val >= max)) {
            return false;
        }
        // For each valid BST subtree, currNode value should be max for left subtree
        // and min for right subtree
        return dfs(currNode.left, min, currNode.val) 
            && dfs(currNode.right, currNode.val, max);
    }
}