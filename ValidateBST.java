
// Time Complexity :O(N)=number of elements in tree
// Space Complexity :0(N)= recursive stack is being used
// Did this code successfully run on Leetcode :
// Three line explanation of solution in plain english

// If we consider inorder of the BST, we get sorted elements, i.e previous element in order is less than current.
//Using this notion, traverse tree recursively using inorder and check if previous element is less than current

// Your code here along with comments explaining your approach

class Solution {
    
    private long preValue;
    public boolean isValidBST(TreeNode root) {
        
        preValue=Long.MIN_VALUE;
        
        return isValidBSTRec(root);
  
    }
    
    private boolean isValidBSTRec(TreeNode root){
        if(root==null){
            
            return true;
        }
        
        boolean isValidLeft=isValidBSTRec(root.left);
        
        boolean isValidCurrent=root.val>preValue;
        preValue=root.val;
        
        boolean isValidRight=isValidBSTRec(root.right);
        
        return isValidLeft&&isValidCurrent&&isValidRight;
        
    }
}