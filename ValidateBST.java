//Time Complexity: O(n) //Traversing through n elements in the tree
//Space Complexity: O(h) //h is the height of the tree.
public class ValidateBST {
    TreeNode prev;
    boolean isValid = true;
    public boolean isValidBST(TreeNode root) {
        helper(root);
        return isValid;
    }

    public void helper(TreeNode root){
        if(root==null){
            return;
        }
        helper(root.left);
        if(prev!=null && root.val<=prev.val){
            isValid = false;
        }
        prev = root;

        if(isValid){
            helper(root.right);
        }
    }
}
