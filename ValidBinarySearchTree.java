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
//--------------------------
//Space complexity:O(H) and Time complexity: O(n)
class ValidBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
         return inorder(root,null,null);
         
    }
    boolean  inorder(TreeNode root,Integer min,Integer max){
       if(root==null) return true;
        if((min!=null && root.val<=min)|| (max!=null && root.val>=max)){
            return false;
        }
        if(inorder(root.left,min,root.val)==false){
            return false;
        }
        return inorder(root.right,root.val,max);
    }
}