// A cleaner solution utilizing logical operators
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) {
            return false;
        }
        if(isSame(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    public boolean isSame(TreeNode curr, TreeNode subRoot) {
        if(curr == null && subRoot == null) {
            return true;
        }
        if(curr == null || subRoot == null) {
            return false;
        }
        if(curr.val != subRoot.val) {
            return false;
        }

        return isSame(curr.left, subRoot.left) && isSame(curr.right, subRoot.right);
    }
}

// Time Complexity: O(N * M) - N: num of nodes in first tree, M: num of nodes in second tree
// Space Complexity: O(logN) - height of the first tree on average case
// Approach: DFS -> pre-order traversal
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) {
            return false;
        }
        // Run isSame function here
        if(isSame(root, subRoot)) {
            return true;
        }
        // Recursively call on left and right subtrees
        boolean findLeft = isSubtree(root.left, subRoot);
        boolean findRight = isSubtree(root.right, subRoot);
        return findLeft || findRight;
    }
    
    public boolean isSame(TreeNode curr, TreeNode subRoot) {
        // If one of the node is null, return false since they are not the same
        if(curr == null) {
            if(subRoot != null) {
                return false;
            } else {
                return true;
            }
        } else{
            if(subRoot == null) {
                return false;
            }
        }
        // If node not equal, return false
        if(curr.val != subRoot.val) {
            return false;
        }
        // Recursively call isSame on left and right subtree
        isSame(curr.left, subRoot.left);
        isSame(curr.right, subRoot.right);
        return true;
    }
}