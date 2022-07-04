// Approach: DFS
// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // If root is null or found target node, return current node
        if(root == null || p.val == root.val || q.val == root.val) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // If not found in left subtree, return right parent
        if(left == null) {
            return right;
        } else {
            // If not found in right subtree, return left parent
            if(right == null) {
                return left;
            } else {
                // If both are found, then root is the common ancestor
                return root;
            }
        }
    }
}

// Approach: BFS
// Time Complexity: O(N)
// Space Complexity: O(N)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        stack.add(root);
        map.put(root, null);
        
        while(!map.containsKey(p) || !map.containsKey(q)) {
            if(root.left != null) {
                stack.add(root.left);
                map.put(root.left, root);
            }
            if(root.right != null) {
                stack.add(root.right);
                map.put(root.right, root);
            }
            root = stack.poll();
        }
        
        LinkedList<TreeNode> parents = new LinkedList<>();
        parents.add(p);
        while(p != null) {
            TreeNode pParent = map.get(p);
            parents.add(pParent);
            p = pParent;
        }
        
        TreeNode qParent = q;
        while(!parents.contains(qParent)) {
            qParent = map.get(qParent);
        }
        return qParent;
    }
}