//Time complexity:- O(n).
//Space complexity:- O(1).
//Did it run on leetcode:- yes.
//What problems did you face:- initially got errors as wrong answers.
// write your approach with the code:- we know in bst left sub tree values max will be parent and right sub tree min value will be parent value 
//based on this property validating each node limits.








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
    public boolean isValidBST(TreeNode root) {
                return isittrue(root,null,null);
    }
    private boolean isittrue(TreeNode TreeNode,Integer low,Integer high){
        if(TreeNode==null){
            return true;
        }
        if((low!=null && TreeNode.val<=low)||((high!=null)&&(TreeNode.val)>=high)){
            return false;
        }
        return isittrue(TreeNode.left,low,TreeNode.val) && isittrue(TreeNode.right,TreeNode.val,high);
    }
}
      