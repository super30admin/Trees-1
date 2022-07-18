//Time Complexity : O(n)
//Space complexity : O(h), where h is the height of tree
//Code run successfully on LeetCode.

public class Problem1_Recursive {

    boolean isValid = true;
    TreeNode prev = null;
    
    public boolean isValidBST(TreeNode root) {
        
        inorder(root);
        return isValid;
    }
    
    private void inorder(TreeNode root){
        
        if(root == null)
            return;
        
        inorder(root.left);
        if(prev!=null && prev.val >= root.val)
        {
            isValid = false;
            return;
        }
        
        prev = root;
        inorder(root.right);
    }
}
