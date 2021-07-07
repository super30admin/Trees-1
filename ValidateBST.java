// ================================= Recursive  approach using min and max =====================================

/*
Time complexity: O(N) where N is number of nodes
Space: O(H) stack space where H is height of the tree

Algorithm:
=========
1. Pick range for a value to be in. For example, root can be from -infinity to +infinity, where as left subtree can only be in the range of -infinity to root.val
and right subtree between root.val and +infinity
2. If this rule is broken by any node, cannot construct a valid BST
3. If it reaches all leaf nodes of tree without returning, valid BST

*/
class Solution {
    public boolean isValidBST(TreeNode root) {
        // Note: If used int max and min, and value is [2147483647], cases fail. So, pick Long max and min
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValidBST(TreeNode root, long min, long max) {
        if(root == null) return true; //reached leaf node 
        if(root.val >= max || root.val <= min) return false; //BST condition failed
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max); //checl for left and right subtrees
        
    }
}

// ============================== Recursive approach using array=======================================
/*
Time complexity: O(N) where N is number of nodes
Space: O(H) stack space plus O(N) auxilliary space for list where H is height of the tree
Algorithm:
=========
1. Use arraylist to keep track of nodes visited so far.
2. Traverse the tree inorder and store values in the list.
3. Check if current value is greater than the last value in the list. Return false if condition fails, else return true

*/
class Solution {
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return helper(root, list);
    }
    
    private boolean helper(TreeNode root, List<Integer> list) {
        if(root == null) return true;
        if(helper(root.left, list) == false) return false; // validate left subtree
        int sz = list.size();
        if(sz > 0 && list.get(sz-1) >= root.val) return false; //validate root
        list.add(root.val);
        if(helper(root.right, list) == false) return false; //validate right subtree
        return true;
    }
}


// ============================== Iterative approach O(1) space =======================================
/**
Algorithm: This approach uses in-order traversal algorithm as if BST, inorder is in ascending order
==========
1. Traverse to left-most part of the tree until null, push to stack to keep track of nodes iterated so far. 
2. Once root is null, pop from stack and check if prev is null and prev node's value is less than root. If not, return false
3. If so, update prev to current node and current node to its right
4. Do this until stack is empty and root is null
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        
        while(root != null || !stack.isEmpty()) {                   // Iterate till root is null and stack is empty
            while( root != null) {                                  // Iterate till we push left most node to the stack and root is null
                stack.push(root);                               
                root = root.left;                                   
            }
            root = stack.pop();                                     // once null, pop element from stack, this should be the smallest if BST
            if( prev != null && root.val <= prev.val) return false; // Check if prev value is smaller than root. if not, return false
            prev = root; 
            root = root.right;                                      // update prev node to root and root to its right
        }
        return true;
    }
}


// ============================== Recursive approach O(1) space =======================================
/**
Algorithm:
=========
Recursive approach of above solution. Always make sure to declare global/local variables right. Here, prev is global as it has to 
be same across calls
 */
class Solution {
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }
    
    private boolean inorder(TreeNode root) {
        //base
        if( root == null) return true;
        //logic
        if(inorder(root.left) == false) return false;       // left subtree doesn't satisfy BST condition
        if(prev != null && root.val <= prev.val) return false; // previous node  value larger than current node val
        prev = root;
        return inorder(root.right);                         // inorder method call on right subtree to validate BST
    }
}







