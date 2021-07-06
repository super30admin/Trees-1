/** 
*Time Complexity : O(n) where n is no. of nodes
*Space Complexity :O(H) H is height of the tree
*
*Did this code successfully run on Leetcode : Yes
*
*Three line explanation of solution in plain english : 
*
*Recursive approach (min-max):
*Traverse down the tree from root and check if left node value is minimum than the root node, similarly 
*right node value is maximum than the root node, if yes then it is a BST. 
*
*/
class Solution {
    public boolean isValidBST(TreeNode node) {
        return validate(node, null, null);
    }
    
    public boolean validate(TreeNode node, Integer max, Integer min){
        if(node == null){// leaf node
            return true;
        }else if( max != null && node.val >= max || min != null && node.val <= min){ // BST condition failed
            return false;
        }else{ 
            return validate(node.left, node.val, min) && validate(node.right, max, node.val);// check left and right subtrees
        }
    }
}
//<----------Recursive Inorder traversal in O(1)------>


class Solution{
    private boolean isValid = true;
    private TreeNode prev = null;    
    public boolean isValidBST(TreeNode root){
        helper(root); 
        return isValid;
    }
    
    private void helper(TreeNode root){
        //base
        if(root == null) 
            return; 
        
        helper(root.left);  //helper method call on left subtree to validate BST
        
        if(prev != null && root.val <= prev.val) { // previous node  value larger than current node val
            isValid = false; 
            return; 
        }            
        prev = root;
        helper(root.right);    // helper method call on right subtree to validate BST
    }
}
