
## Problem 1

https://leetcode.com/problems/validate-binary-search-tree/

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:

   2

   / \

  1   3

Input: [2,1,3]
Output: true
Example 2:

   5

   / \

  1   4

     / \

    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.

// In this solution we are doing an inorder traversal and checking if previous visited node is smaller or not if it is 
// smaller then it's fine else thst is not a BST
Time Complexity : O(n)
Space Complexity: O(h)
class Solution {
        TreeNode prev;
        boolean isValid;
    public boolean isValidBST(TreeNode root) {
        //Best case check
        if(root==null){
            return true;
        }
        isValid = true;
        inorder(root);
        return isValid;
        
    }
    private void inorder(TreeNode root){
        //Base condition
        if(root == null){
            return;
        }
        //Left call
        inorder(root.left);
        //processing
        if(prev!=null && prev.val>=root.val){
            isValid=false;
        }
        prev=root;
        //Right call
        inorder(root.right);
    }
}
//Iterative Approach
Time Complexity : O(n)
Space Complexity: O(h)
class Solution {
    boolean isValid;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        isValid = true;
        inorder(root);
        return isValid;
        
    }
    private void inorder(TreeNode root){

        Stack<TreeNode> st=new Stack<>();
        while(root!=null || !st.isEmpty()){
            while(root!=null){
                st.push(root);
                root=root.left;
            }
            root=st.pop();
            if(prev!=null && prev.val>=root.val){
                isValid=false;
                break;
            }
            prev=root;
            root=root.right;
        }


    }
        
}


//Min Max approach
Time Complexity : O(n)
Space Complexity: O(h)
class Solution {
    boolean isValid;
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        isValid=true;
        inorder(root,null,null);
        return isValid;
    }
    private void inorder(TreeNode root, Integer min, Integer max){
        if(root == null){
            return;
        }
        inorder(root.left,min,root.val);
        if((min!=null && root.val <=min) || (max!=null && root.val>=max)){
            isValid=false;
            return;
        }
        inorder(root.right,root.val,max);
    }
}

//Local variable
Time Complexity : O(n)
Space Complexity: O(h)
class Solution {
    boolean isValid;
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        isValid = true;
        inorder(root,null);
        return isValid;
        
    }
    private void inorder(TreeNode root, TreeNode prev){
        if(root == null){
            return;
        }
        inorder(root.left, prev);
        //processing
         
        if(prev!=null && prev.val>=root.val){
            isValid=false;
            return;
        }
       prev=root;
        inorder(root.right,prev);
    }
}

//Code Optimization
Time Complexity : O(n)
Space Complexity: O(h)
class Solution {
    boolean isValid;
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        return inorder(root,null,null);
    }
    private boolean inorder(TreeNode root, Integer min, Integer max){
        if(root == null){
            return true;
        }
        boolean case1= inorder(root.left,min,root.val);
        if((min!=null && root.val <=min) || (max!=null && root.val>=max)){
            return false;
        }
        boolean case2=inorder(root.right,root.val,max);
        return case1&& case2;
    }
}

//Code Optimization
Time Complexity : O(n)
Space Complexity: O(h)
class Solution {
    boolean isValid;
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        return inorder(root,null,null);
    }
    private boolean inorder(TreeNode root, Integer min, Integer max){
        if(root == null){
            return true;
        }
        if((min!=null && root.val <=min) || (max!=null && root.val>=max)){
            return false;
        }
        return (inorder(root.left,min,root.val)) && (inorder(root.right,root.val,max));
    }
}