import javax.swing.tree.TreeNode;

//Time Complexity: O(h), h is the height of the tree
//Space Complexity: O(n)

class Solution {
    
    //creating the previous node while we move to the left and right nodes
    //and we can compare the root node with the left and right to validate
    TreeNode prev;
    boolean flag;
    
    //making the above node and flag global so they are accesible thru multiple functions
    
    public boolean isValidBST(TreeNode root) {
        flag = true;
        inOrder(root);
        return flag;
    }
    
    private void inOrder(TreeNode root)
    {
        //this is so we do not go to next line of code 
        //and search for left and right nodes of a null node
        if(root == null) return;
        
       //we recursively check if the left node is in order 
        inOrder(root.left);
        
        //first, we check if the root val is not the first root node
        //second, we make sure that the val of root is larger than at prev
        if(prev != null && prev.val >= root.val)
            flag = false;
        
        //setting the current root node as the previous node   
        prev = root;
        
        //we recurively check if the right node is in order
        inOrder(root.right);
    } 
}
