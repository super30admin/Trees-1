// Time Complexity : O(N) where N is the number of nodes
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach: Take a two pointer approach, move the prev and root values and recusively check if valid
public class ValidateBST {
    TreeNode prev=null;
    public boolean isValidBST(TreeNode root) {
        return isValid(root);
    }

    private boolean isValid(TreeNode root){
        if(root==null) return true;

        boolean left=isValid(root.left);
        if(prev!=null && prev.val>=root.val) return false;

        prev=root;


        boolean right=isValid(root.right);

        return left && right;
    }
}
//https://youtu.be/z1MtGavNPZY