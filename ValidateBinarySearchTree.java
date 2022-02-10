//TC: O(n)(worst case becas we ll travel through all nodes)
//SC: O(1)
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
    boolean flag;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        flag = true;
        prev = null;
        inorder(root); 
        return flag;
    }
    
    private void inorder(TreeNode root){
        
        //null check   
        if(root == null) return;
      
        //logic
        
        inorder(root.left);
        //st.pop()
        if(prev != null && prev.val >= root.val){
            flag = false;
        }
        prev = root;   
        
        inorder(root.right);
        //st.pop()
    }
}