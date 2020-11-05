// Time Complexity : O(n), where n is the number of nodes in the tree
// Space Complexity :O(n), where n is the height of the tree, to maintain stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : not clear, if how function level return terminates the program, but base case level return 
                                                //does not??


// Your code here along with comments explaining your approach

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
class Solution {
    //declaring prev as global variable
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        //intialize as null
         prev = null;
        
        return helper(root);
    }
    
    private boolean helper(TreeNode root){
        //while(root != null ||!stack.isEmpty())
        if(root == null) return true;
        
          //add all the left childs of a node, till the leaf node
            //while(root != null){
            //stack.push(root);
            //root = root.left;
                //}
         //once the leaf node is done traversing, pop it from the stack
            //root = stack.pop();
        if(helper(root.left) == false) return false; //equivalent to above 7 lines of comments
            
        //In BST, the previous node should be smaller than the current node
        if(prev !=null && prev.val >= root.val) return false;
            prev = root;
        //go the right child of the root
        return helper(root.right);
            
        }
    
}