// Time Complexity : O(N)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Recursive for printing inorder BST
class Solution{

    boolean result;

    public boolean inorderBST2(TreeNode root){
        if(root == null)
            return true;

        inorder(root);
        return true;
    }

    private void inorder(TreeNode root){

        //base
        if(root == null){
            return;
        }

        //logic

        //until it doesn't reach the leaf and become null we keep pushing left values
        inorder(root.left);
        //then we print the root once we hit null
        System.out.println(root.val);
        //the new root becomes the right one
        inorder(root.right);
    }
}