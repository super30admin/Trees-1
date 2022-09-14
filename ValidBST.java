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

 // RECURSIVE APPROACH
// Optimized Valid BST without boolean
class ValidBST {
    TreeNode prev;
    boolean flag;
    public boolean isValidBST(TreeNode root) {
        flag = true;
        inorder(root);
        return flag;
    }
    private void inorder(TreeNode root){
        if(root==null) return;
        
        if(flag)
        inorder(root.left);
        
        if(prev!=null && prev.val>=root.val){
            flag = false;
        }
        prev = root;
        
        if(flag)
        inorder(root.right);
        
    }
}

// Optimized Valid BST with boolean
class ValidBST1 {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }
    private boolean inorder(TreeNode root){
        if(root==null) return true;
        
        if(inorder(root.left)==false) return false;
        
        if(prev!=null && prev.val>=root.val){
            return false;
        }
        prev = root;
        
        return inorder(root.right);
    }
}

// ITERAVTIVE APPROACH
class ValidBST2 {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode prev = null;
        while(root!=null || !st.isEmpty()){
            while(root!=null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if(prev!=null && prev.val>=root.val){
                return false;
            }
            prev = root;
            root = root.right;
        }
        return true;
    }
}

// LIMITS APPROACH
class ValidBST3 {
    public boolean isValidBST(TreeNode root) {
        return helper(root,null,null);
    }
    private boolean helper(TreeNode root, Integer min, Integer max){
        // base case
        if(root==null) return true;
        if(min!=null && root.val<=min) return false;
        if(max!=null && root.val>=max) return false;
        
        //logic
        return helper(root.left,min,root.val) && helper(root.right,root.val,max);
    }
}

// Time Complexity - O(n) [n - touching each node]
// Space Complexity - O(h) [h - height of the tree]