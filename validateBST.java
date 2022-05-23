//Time - O(n)
//Space - O(h)
//did it run in leet code - yes
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
     boolean isValid;
    public boolean isValidBST(TreeNode root) {
      prev = null;
      isValid = true;
      inorder(root);
      return isValid;
    }
    private void inorder(TreeNode root){
        if(root == null) return ;
        inorder(root.left);
        if(prev!=null && prev.val>= root.val) { isValid = false; return ;}
        prev = root;
        if(isValid){
        inorder(root.right);}
        System.out.println("root" + root.val);
      
        return;
    }
    
}