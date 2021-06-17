// 98. Validate Binary Search Tree

class Solution {
    TreeNode prev ;
    public boolean isValidBST(TreeNode root) {
        // Recursive solution starts here  
        if(root == null) return true;
        return inorder(root);   
    }
        
    private boolean inorder(TreeNode root){
        
        if(root == null) return true;
        
        if(inorder(root.left) == false) return false;
        
        if(prev != null && prev.val >= root.val) return false;
        prev = root;
        
        return inorder(root.right);
    }
}  

/* 
Time complexity : 
O(N) in the worst case when the tree is BST or the "bad" element is a rightmost leaf.

Space complexity : 
O(1)  

*/
