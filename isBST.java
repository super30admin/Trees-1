/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Time complexity : O(n) n - number of nodes in tree
//Space complexity: O(n)
class Solution {
   
    public boolean isValidBST(TreeNode root) {
      return validate(root, null, null);
    }
    
    public boolean validate(TreeNode root, Integer max, Integer min)
    {
        if(root==null)
            return true;
        
        else if (max!= null && root.val>=max|| min != null && min>=root.val) return false;
        else 
        {
           return validate(root.left, root.val, min) && validate(root.right, max, root.val);
        }
    }
}