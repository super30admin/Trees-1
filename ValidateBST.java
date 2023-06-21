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
    private boolean flag;
    private TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        flag = true;
        inorder(root);
        return flag;
    }
    private void inorder(TreeNode root){
        if(root == null) return;

        // logic
        inorder(root.left);
        if(prev==null){
            System.out.println("up null"+ root.val);
        }else{
        System.out.println("up " + root.val+ " "+prev.val);
        }
        if(prev!=null && prev.val >= root.val){
            flag = false;
        }
        prev = root;
        inorder(root.right);
        
        
        System.out.println("down " + root.val+ " "+prev.val);
    }
}