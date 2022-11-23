// Time Complexity: O(N)
// Space Complexity: O(N)
// Approach: DFS + DP
class Solution {
    int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        findMax(root);
        return maxSum;
    }
    
    public int findMax(TreeNode node) {
        if(node == null) {
            return 0;
        }
        // consider the gain only if positive, else we ignore it
        int leftMax = Math.max(findMax(node.left), 0);
        int rightMax = Math.max(findMax(node.right), 0);
        maxSum = Math.max(maxSum, leftMax + rightMax + node.val);
        // the path can only go from curr->left or curr->right
        // which means the sum is not sum of all subtree nodes
        return Math.max(leftMax + node.val, rightMax + node.val);
    }
}