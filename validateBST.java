/**
 * 
 * Leet Code - 98
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
    //DONT initialize prev here
    //TreeNode prev = new TreeNode(Integer.MIN_VALUE); results in [Integer.MIN_VALUE] failed test case
	//TreeNode prev should be in global scope not local scope/recursive scope!!!
    TreeNode prev; 
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return false;
        return validateBST(root);
    }
    private boolean validateBST(TreeNode root)
    {
        if (root == null)
            return true;
        //st.push(root)
        System.out.println("root UP:" + root.val);
        if(!validateBST(root.left)){
            return false;
        }
        //st.pop()-popped the current root from the stack
        System.out.println("root DOWN:" + root.val);
        if(prev!=null && root.val <= prev.val)
            return false;
        prev = root;
        //st.push(root)
        if(!validateBST(root.right))
        {
            return false;
        } 
        //st.pop()-popped the current root from the stack
        return true;
    }
}