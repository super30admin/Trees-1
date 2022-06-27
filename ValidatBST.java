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
    
    
    
    
    /**
     * Here traverse on to every node using inorder to validate if a given tree is BST
     *
     * 'n' nodes in a given tree
     *
     * Time complexity: O(n) As we should visit all `n` nodes as any node can have breach.
     *
     * Space complexity: Recursive stack space. 
     *      
     *      O(height of the tree). Height is O(logn) for BST.
     *
     *      For a normal tree, at any given time we will not have all the nodes in the recursive stack.
     *      
     *      For a skewed tree, we will have all the nodes except one in the leaf. 
     *      Then height becomes O(h) which will be O(n)
     *  
    */
    
    // Used to track if there is breach in in-order traversal
    private TreeNode prev;
    
    // Since this is a void fn, isValid is used to indicate if tree is BST or not at the end.
    boolean isValid = true;
    
    public boolean isValidBST(TreeNode root) {
        // Calling inorder with root element.
        inorder(root);
        return isValid;
    }
    
    
    // Use inorder to traverse the tree
    private void inorder(TreeNode root) {
        
        //base
        if(root == null)
            return;
        
        inorder(root.left);
        
        //root = st.pop() -> Indicate an internal state of root after coming out of above recursive call.
        
        //validate: Check if current element is greater than root, 
        //if its a BST  current element should be greater than or equal to previous element always
        if(prev!= null && prev.val >= root.val) 
            isValid = false;
        
        prev = root;
        
        inorder(root.right);
        
        //root = st.pop() -> Indicate an internal state of root after coming out of above recursive call.
        
        return;
    }
    
}
