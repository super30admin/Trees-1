/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        
        return isValidBST(root, null, null);
        
    }
    
    private boolean isValidBST(TreeNode root, Integer min, Integer max){
        //Base Case
        if(root == null){
            return true;
        }       
        
        if((max != null && root.val >= max) || (min != null && root.val <= min)){
            return false;
        }
        
        //Logic
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max); 
        
    }
}