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
// Time Complexity : O(n) 
// Space Complexity : O(h) h is height of tree
// Did this code successfully run on Leetcode : Yes

class Solution {
    TreeNode prev = null;
    boolean isValid = true;
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        inorder(root);
        return isValid;
    }
    private void inorder(TreeNode root){
        if(root == null)
            return;
        inorder(root.left);
        if(prev != null && prev.val >= root.val){
            isValid = false;
            return;
        }
        prev = root;
        inorder(root.right);
    }
}


/*
class Solution {
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        return inorder(root);
    }
    private boolean inorder(TreeNode root){
        if(root == null)
            return true;
        if(inorder(root.left) == false)
            return false;
        if(prev != null && prev.val >= root.val)
            return false;
        prev = root;
        
        return inorder(root.right);
    }
}
*/

/*
//iterative solution
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        TreeNode prev = null;
        Stack<TreeNode> st = new Stack<>();
        while(root != null || !st.isEmpty()){
            while(root != null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if(prev != null && prev.val >= root.val)
                return false;
            prev = root;
            root = root.right;
        }
        return true;
    }
}
*/