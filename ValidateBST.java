// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class ValidateBST {
    boolean flag = true;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        if(root!=null){
            helper(root);
        }
        return flag;
    }

    public void helper(TreeNode root){
        //System.out.println(root.val);
        //Inorder in a BST means the sequence of nodes should be strictly increasing so we check if curr>prev or not.
        if(root.left!=null) helper(root.left);
        if(prev!=null){
            if(prev.val>=root.val){
                flag = false;
                return;
            }
        }
        prev = root;
        if(root.right!=null) helper(root.right);
    }

    public static void main(String [] args){

    }
} 