// There are three approaches
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

import java.util.Stack;

// Your code here along with comments explaining your approach
// Approach 1: Iterative Solution
// Time Complexity : O(n)
//      n: number of elements
// Space Complexity : O(h)
//      h: height of the tree/ depth of tree

class Problem1S1 {
    /**Definition for a binary tree node.*/
    class TreeNode {

        // member variable
        int val;
        // referneces
        TreeNode left;
        TreeNode right;

        // default constructor
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /** returs true if valid BST */
    public boolean isValidBST(TreeNode root) {
        
        // edge case
        if(root==null)
            return true;
        
        // previous node
        TreeNode prev = null;
        Stack<TreeNode> myStack = new Stack<>();

        // iterate 
        while(root!=null || myStack.isEmpty()==false){
            
            // go to left most branch 
            while(root!=null){
                myStack.add(root);
                root = root.left;
            }
            
            // pop out
            root = myStack.pop();
            // check if it less than previous
            if(prev!=null && prev.val >= root.val)
                return false;
            // go to right branch
            prev = root;
            root = root.right;
                  
        }
        return true;
    }
}

// Your code here along with comments explaining your approach
// Approach 2: Recursive Solution
// Time Complexity : O(n)
//      n: number of elements
// Space Complexity : O(1)
//     we dont count recursive space otherwise O(h)
//      h: height of the tree/ depth of tree
class Problem1S2 {

    /**Definition for a binary tree node.*/
    class TreeNode {

        // member variable
        int val;
        // referneces
        TreeNode left;
        TreeNode right;

        // default constructor
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // global previous
    TreeNode prev = null;

    /** validate BST */
    public boolean isValidBST(TreeNode root) {
        return helper(root);
    }
    
    /**helper function */
    private boolean helper(TreeNode root){

        // base case
        if(root==null)
            return true;
        
        // go towards left sub tree
        boolean result = helper(root.left);

        // check previous value with root
        if(result==false ||(prev!=null && prev.val >= root.val))
            return false;
        // update previous
        prev=root;
        // go right sub tree
        result = helper(root.right);
        return result;
        
    }
}

// Your code here along with comments explaining your approach
// Approach 2: Recursive Solution using range -> min < val < max
// 1. Every node should be in range
// 2. left-tree -> (-ve inf) < left < root
// 3. right-tree -> root< right < (+ve inf)
// Time Complexity : O(n)
//      n: number of elements
// Space Complexity : O(1)
//     we dont count recursive space otherwise O(h)
//      h: height of the tree/ depth of tree
class Problem1S3 {

    /**Definition for a binary tree node.*/
    class TreeNode {

        // member variable
        int val;
        // referneces
        TreeNode left;
        TreeNode right;

        // default constructor
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /** validate BST */
    public boolean isValidBST(TreeNode root) {
        // using null to avoid Intger overflow error
        return helper(root, null, null);
    }
    
    /**helper function */
    private boolean helper(TreeNode root, Integer min, Integer max){
        // base case
        if(root==null)
            return true;
        // not in range
        if((min!=null && root.val <= min) || (max!=null && root.val >=max))
            return false;
        // in range
        else{
            // left side max is root
            boolean leftSubTree = helper(root.left, min, root.val);
            // right side min is root
            return leftSubTree && helper(root.right, root.val, max);
        }
        
    }
}