//Time Complexity:O(n)
//Space Complexity:O(1)

//Recurse through the list to see if left node value is lesser than root and right node value is greater than root.
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
        if(root==null) return true;
        return helper(root, null, null);
        
    }
    
    public boolean helper(TreeNode root, Integer l, Integer r){
        
        if(root==null) return true;
        if(l!=null && l>=root.val)
            return false;
        if(r!=null && r<=root.val)
            return false;
        else
            return (helper(root.left,l,root.val) && helper(root.right,root.val,r));
        
    }
}
