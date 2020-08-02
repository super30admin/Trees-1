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
        Stack<TreeNode> st = new Stack<>();
        TreeNode prev = null;
        if(root == null) return true;
        while(root != null || !st.isEmpty()){
            while(root != null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if(prev!=null && prev.val >= root.val) return false;
            prev = root;
            root = root.right;
        }
        return true;
    }
}


class Solution {
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }
    
    private boolean inorder(TreeNode root){
        if(root == null) return true;
        if(inorder(root.left)==false) return false;
        if(prev!=null && prev.val >= root.val) return false;
        prev=root;
        return inorder(root.right);
    }
}
