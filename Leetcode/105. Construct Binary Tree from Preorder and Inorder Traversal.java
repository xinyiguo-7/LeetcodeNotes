// Time Complexity: O(N)
// Space Complexity: O(N)
// For preorder traversal, go level by level, from left to right
// For inorder traversal, left and right nodes are on the left or right sides of their root
// Therefore, for inorder, we could start from the root, and recursively build left and right subtree
// Use preorder index to get the roots in order, and use inorder index to justify if we have 
// finished building this subtree
class Solution {
    int preorderIndex;
    HashMap<Integer, Integer> inorderIndex;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        inorderIndex = new HashMap<>();
        // store value - inorder index into hashmap
        for(int i = 0; i < inorder.length; i++) {
            inorderIndex.put(inorder[i], i);
        }
        return buildSubtree(preorder, 0, preorder.length - 1);
    }
    // Left and right as inorder index range, to check whether there are
    // still nodes to add
    public TreeNode buildSubtree(int[] preorder, int left, int right) {
        // no more values to put in tree
        if(left > right) {
            return null;
        }
        int rootVal = preorder[preorderIndex];
        TreeNode root = new TreeNode(rootVal);
        preorderIndex++;
        
        root.left = buildSubtree(preorder, left, inorderIndex.get(rootVal) - 1);
        root.right = buildSubtree(preorder, inorderIndex.get(rootVal) + 1, right);
        return root;
    }
}