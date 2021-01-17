// Time Complexity : O(n)
// Space Complexity : O(h), h = height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Understanding the recursive solution

// Notes : Iterate towards the left part of the tree to find the left-most non-null node, compare each node with the previous node that was recorded and check for BST validity. If the nodes comply with BST rules, goto the right part of the tree and repeat these steps recursively. 

public class ValidateBinaryVearchTree {

    //Solution 1 : Recursive code
    TreeNode prevNode = null;
    boolean validBST;
    
    public boolean isValidBST(TreeNode root) {
    
        if(root == null) return false;
        
        validBST = true;
        BSTRecursion(root);
        
        return validBST;
    }
    
    private void BSTRecursion(TreeNode root){
        //base case
        if(root == null) return;
        
        //recursive case
        BSTRecursion(root.left);
        
        if(prevNode != null && prevNode.val >= root.val){
            validBST = false;
            return;
        }
            
        prevNode = root;
        
        BSTRecursion(root.right); 
    }

    //Solution 2 : Iterative code
    // TreeNode prevNode = null;
    // public boolean isValidBST(TreeNode root) {
    
    //     if(root == null) return false;
    //     if(root.left == null && root.right == null) return true;
        
    //     Stack<TreeNode> stack = new Stack<TreeNode>();
                
    //     while(root != null || !stack.isEmpty() ){
            
    //         //go towards the leftmost leaf
    //         while( root != null ) {
    //             stack.push(root);
    //             root = root.left;
    //         }
            
    //         root = stack.pop();

    //         if(prevNode != null && prevNode.val >= root.val ) return false;
            
    //         prevNode = root;
     
    //         //go towards the right node
    //         root = root.right;
    //     }
        
    //     return true;
    // }
}
