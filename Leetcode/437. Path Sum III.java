// Approach: Prefix Sum + Map
// Discussion solution
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        int res = helper(root, targetSum, map, 0);
        return res;
    }
    
    public int helper(TreeNode root, int targetSum, Map<Long, Integer> map, long sum){
        int res = 0;
        if(root==null) {
            return res;
        }
        long tmp = sum + root.val;
        if(map.containsKey(tmp - targetSum)){
            res += map.get(tmp - targetSum);
        }
        map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        res += helper(root.left, targetSum, map, tmp);
        res += helper(root.right, targetSum, map, tmp);
        map.put(tmp, map.getOrDefault(tmp, 0) -1 );
        if(map.get(tmp) <= 0){
            map.remove(tmp);
        }
        return res;
    }
}

// Leetcode solution: to help understanding
class Solution {
    int count = 0;
    int k;
    HashMap<Integer, Integer> h = new HashMap();
    
    public void preorder(TreeNode node, int currSum) {
        if (node == null)
            return;
        
        // current prefix sum
        currSum += node.val;

        // here is the sum we're looking for
        if (currSum == k)
            count++;
        
        // number of times the curr_sum − k has occured already, 
        // determines the number of times a path with sum k 
        // has occured upto the current node
        count += h.getOrDefault(currSum - k, 0);
        
        // add the current sum into hashmap
        // to use it during the child nodes processing
        h.put(currSum, h.getOrDefault(currSum, 0) + 1);

        // process left subtree
        preorder(node.left, currSum);
        // process right subtree
        preorder(node.right, currSum);

        // remove the current sum from the hashmap
        // in order not to use it during 
        // the parallel subtree processing
        h.put(currSum, h.get(currSum) - 1);
    }    
            
    public int pathSum(TreeNode root, int sum) {
        k = sum;
        preorder(root, 0);
        return count;
    }
}

class Solution {
    private int pathNum;
    public int pathSum(TreeNode root, int targetSum) {
        pathNum = 0;
        dfs(root, new LinkedList<>(), targetSum, 0);
        return pathNum;
    }
    
    public void dfs(TreeNode node, Queue<TreeNode> path, int targetSum, int curSum) {
        int debugNum = pathNum;
        if(node == null) {
            return;
        }
        curSum += node.val;
        if(curSum > targetSum) {
            TreeNode start = path.poll();
            if(start != null) {
                curSum -= start.val;
                if(curSum == targetSum) {
                    pathNum++;
                }
            } else {
                curSum = 0;
            }
        } else if(curSum == targetSum) {
            pathNum++;
            curSum = 0;
            path = new LinkedList<>();
        } else {
            path.add(node);
        }
        dfs(node.left, path, targetSum, curSum);
        dfs(node.right, path, targetSum, curSum);
    }
}