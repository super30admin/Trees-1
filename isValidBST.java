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
    TreeNode prev;
    boolean flag;
    public boolean isValidBST(TreeNode root) {
        flag=true;
        inorder(root);
        return flag;
    }
    
    public void inorder(TreeNode root)
    {
        if(root==null) return; // if Leaf Return
        
        
        inorder(root.left);   // Go to Left Sub Tree
                              // st.pop()
        if(prev!=null&&prev.val>=root.val) //Compare prev Node if it is not null
        {
            flag=false;
        }
        prev=root;      //Change the prev 
        
        inorder(root.right);    // Move to the right subtree
    }
}