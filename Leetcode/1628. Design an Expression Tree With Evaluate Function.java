/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */

class Node {
    // define your fields here
    int val;
    char operator;
    Node left, right;
    boolean isVal, isOp;
    
    public Node(int val) {
        this.val = val;
        this.isVal = true;
        this.isOp = false;
    }
    public Node(char op) {
        this.operator = op;
        this.isVal = false;
        this.isOp = true;
    }
    public int evaluate() {
        if(!isOp) {
            return this.val;
        }
        int left = this.left.evaluate();
        int right = this.right.evaluate();
        return compute(this.operator, left, right);
    }
    public int compute(char op, int val1, int val2) {
        if(op == '+')
            return val1 + val2;
        if(op == '-')
            return val1 - val2;
        if(op == '*')
            return val1 * val2;
        if(op == '/')
            return val1 / val2;
        return 0;
    }
};


/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input 
 * and returns the expression tree represnting it as a Node.
 */

class TreeBuilder {
    Node buildTree(String[] postfix) {
        Deque<Node> stack = new ArrayDeque<>();
        
        for(String str : postfix) {
            if(Character.isDigit(str.charAt(0))) {
                Node n = new Node(Integer.parseInt(str));
                stack.push(n);
            } else {
                Node n1 = stack.pop();
                Node n2 = stack.pop();
                Node op = new Node(str.charAt(0));
                // Since stack is last in first out, the order is reversed
                op.right = n1;
                op.left = n2;
                stack.push(op);
            }
        }
        return stack.peek();
    }
};


/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */