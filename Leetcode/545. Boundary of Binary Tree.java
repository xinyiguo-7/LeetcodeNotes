// Approach: DFS
public class Solution {

    public boolean isLeaf(TreeNode t) {
        return t.left == null && t.right == null;
    }

    public void addLeaves(List<Integer> res, TreeNode root) {
        if (isLeaf(root)) {
            res.add(root.val);
        } else {
            if (root.left != null) {
                addLeaves(res, root.left);
            }
            if (root.right != null) {
                addLeaves(res, root.right);
            }
        }
    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        if (!isLeaf(root)) {
            res.add(root.val);
        }
        TreeNode t = root.left;
        while (t != null) {
            if (!isLeaf(t)) {
                res.add(t.val);
            }
            if (t.left != null) {
                t = t.left;
            } else {
                t = t.right;
            }

        }
        addLeaves(res, root);
        Stack<Integer> s = new Stack<>();
        t = root.right;
        while (t != null) {
            if (!isLeaf(t)) {
                s.push(t.val);
            }
            if (t.right != null) {
                t = t.right;
            } else {
                t = t.left;
            }
        }
        while (!s.empty()) {
            res.add(s.pop());
        }
        return res;
    }
}

// Approach: BFS (Partially done)
class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> boundary = new ArrayList<>();
        LinkedList<TreeNode> level = new LinkedList<>();
        LinkedList<Integer> rightBound = new LinkedList<>();
        
        boundary.add(root.val);
        level.add(root);
        while(!level.isEmpty()) {
            
            LinkedList<TreeNode> newLevel = new LinkedList<>();

            boolean firstLeft = false;
            
            while(!level.isEmpty()) {
                TreeNode node = level.removeFirst();
                boolean isLeaf = true;
                if(node.left != null) {
                    newLevel.add(node.left);
                    if(firstLeft == false) {
                        boundary.add(node.left.val);
                        firstLeft = true;
                    }
                    isLeaf = false;
                }
                if(node.right != null) {
                    newLevel.add(node.right);
                    if(firstLeft == false) {
                        boundary.add(node.right.val);
                        firstLeft = true;
                    }
                }
            }
            
            level = newLevel;
        }
        
        while(!rightBound.isEmpty()) {
            boundary.add(rightBound.removeLast());
        }
        return boundary;
    }
}