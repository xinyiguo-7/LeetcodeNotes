// Approach 1: Using BST property
// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        
        TreeNode successor = null;

        while (root != null) {
            // If target value >= root, disgard the left tree, 
            // target must be on the right
            if (p.val >= root.val) {
                root = root.right;
            } else {
                // If going left, then current node is potential successor for target
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }
}

// Approach 2: In order traversal
// Time Complexity: O(N)
// Space Complexity: O(N)
class Solution {
    public LinkedList<TreeNode> inorderNodes = new LinkedList<>();
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        inorderTraversal(root);
        int N = inorderNodes.size();
        for(int i = 0; i < N; i++) {
            if(inorderNodes.get(i).val == p.val && i != N - 1) {
                return inorderNodes.get(i + 1);
            }
        }
        return null;
    }
    
    public void inorderTraversal(TreeNode root) {
        if(root == null) {
            return;
        }
        inorderTraversal(root.left);
        inorderNodes.add(root);
        inorderTraversal(root.right);
    }
}