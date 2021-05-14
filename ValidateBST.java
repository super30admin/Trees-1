// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//Time Complexity : O(n) since we are traversing across all the nodes in the tree in worst case scenario
//Space Complexity: O(1) since we are not taking any extra space

 class Solution {
    
    TreeNode prev = null;
    
    public boolean isValidBST(TreeNode root) 
    {     
        //base condition
        if(root == null) return true;
        
        //logic
        if(isValidBST(root.left) == false) return false;
        //Since traversing through the BST results in a sorted order, 
        //if the current prev root value is greater than current root val, then it is not a BST
        if(prev != null && prev.val >= root.val) return false; 
        prev = root;
        return isValidBST(root.right);
    }
}