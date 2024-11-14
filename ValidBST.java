/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// Approach : Iterative Solution with in order traversal
// Time : O(N) # worst case we visit all the nodes
// Space : O(N) 
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        Stack<TreeNode> stk = new Stack<>();
        TreeNode prev = null;
        while(root!=null || !stk.isEmpty()){
            // going left->left->left..
            while(root!=null){
                stk.push(root);
                root=root.left;
            }
            root=stk.pop();
            if(prev!=null && prev.val>=root.val) return false;
            prev=root;
            root=root.right;
        }
        return true;
    }
}

// Approach : Recursive solution with global prev - In order traversal
// Time : O(N) # worst case we visit all the nodes
// Space : O(N) 
class Solution {
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return inOrder(root);
    }
    public boolean inOrder(TreeNode root){
        
        // base
        if(root==null) return true; // it will never give a function call return because !stk.isEmpty() under the hood 

        // logic
        if(inOrder(root.left)==false) return false; // if left subtree is not a BST then return directlty
        // under the hood stk.pop()
        if(prev!=null && prev.val>=root.val) return false;
        prev=root;
        return inOrder(root.right); // can be true or false
    }
}

// Approach : Recursive solution with ranges - In Order Traversal
// Time : O(N) # worst case we visit all the nodes
// Space : O(N) 
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return helper(root,null,null); // helper(root,min,max)
    }
    public boolean helper(TreeNode root,Integer min, Integer max){
        
        // base
        if(root==null) return true; // it will never give a function call return because !stk.isEmpty() under the hood 

        // logic
        if((max!=null && root.val >=max) || (min!=null && root.val<=min)) return false;
        return helper(root.left,min,root.val) && helper(root.right,root.val,max); // can be true or false
    }
}

 // Approach : Recursive solution (In order traversal) with local prev will not work because prev will also inserted into the stack and it may not
 // go and check BST valid condition.
 // Time : O(N) # worst case we visit all the nodes
// Space : O(N) 
class Solution {
    //TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return inOrder(root,null);
    }
    public boolean inOrder(TreeNode root,TreeNode prev){
        
        // base
        if(root==null) return true; // it will never give a function call return because !stk.isEmpty() under the hood 

        // logic
        if(inOrder(root.left,prev)==false) return false; // if left subtree is not a BST then return directlty
        System.out.println(prev);
        if(prev!=null && prev.val>=root.val) return false;
        prev=root;
        return inOrder(root.right,prev); // can be true or false
    }
}

