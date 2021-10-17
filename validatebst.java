//TC:
//SC:
//successfuly ran on leetcode
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
    public boolean isValidBST(TreeNode root)
    {
        return validate(root,null,null);
    }
    private boolean validate(TreeNode node,Integer low,Integer high)
    {
        //chech node
        if(node==null)
        {
            return true;
        }

        //check node value
        if((low!=null && node.val<=low) || (high!=null && node.val>=high))
            return false;

        return validate(node.left,low,node.val) && validate(node.right,node.val,high);


    }
}
