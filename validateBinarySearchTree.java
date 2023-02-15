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
//void function
//TC: O(n)
//SC: O(height of tree)
class Solution {
    boolean flag;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        flag = true;
        inorder(root);
        return flag;
    }
    
    private void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        //st.pop()--> root
        if(prev != null && prev.val >= root.val){
            flag = false;
        }
        prev = root;
        if(flag)
            inorder(root.right);
    }
}




//boolean function
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

//TC: O(n)
//SC: O(height of tree)
class Solution {

    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        return inorder(root);     
    }
    
    private boolean inorder(TreeNode root){
        if(root == null) return true;
        boolean left = inorder(root.left);
        //st.pop()--> root
        if(prev != null && prev.val >= root.val){
            return false;
        }
        prev = root;
        boolean right = inorder(root.right);
        return left && right;
    }
}
