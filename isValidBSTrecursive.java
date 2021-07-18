// Time Complexity : O(N)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Recursive
class Solution{

    boolean result;
    TreeNode prev;

    public boolean isValidBST2(TreeNode root){
        if(root == null)
            return true;

        result = true;
        inorder(root);
        return result;
    }

    private void inorder(TreeNode root){

        //base
        if(root == null){
            return;
        }

        //logic

        //until it doesn't reach the leaf and become null we keep pushing left values
        inorder(root.left);

        //we check for validity
        if(prev != null && prev.val >= root.val){
                result = false;
                return; //once it is false, we dont need to iterate further
            }
        prev = root;
        
        //the new root becomes the right one
        inorder(root.right);
    }
}