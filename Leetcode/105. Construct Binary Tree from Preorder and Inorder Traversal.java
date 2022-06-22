// Time Complexity: O(N)
// Space Complexity: O(N)
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