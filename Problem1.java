// https://leetcode.com/problems/validate-binary-search-tree/

class Solution {

    // Doing an in-order recursively and checking if prev<curr node
    // Time - O(N)
    // Space - O(log N) occupied by recursive calls
    private boolean flag=true;
    private TreeNode prev=null;
    private void inOrder1(TreeNode root){
        // base
        if(root==null)  return;

        inOrder1(root.left);
        //logic
        if(prev!=null && prev.val>=root.val){
            // breach of BST property
            flag=false;
        }
        prev=root;
        if(flag)    inOrder1(root.right);
    }

    // At each node check if curr node is within valid range
    // Valid range: (Max of left sub-tree) < curr.val < (Min of right sub-tree)
    // And both left and right sub-trees should be BST
    // Time - O(N)
    // Space - O(log N) occupied by recursive calls
    private boolean flag2=true;
    private void inOrder2(TreeNode root, Integer min, Integer max){
        // base
        if(root==null)  return;

        inOrder2(root.left, min, root.val);
        //logic
        if(min!=null && min>=root.val){
            // breach of BST property
            flag2=false;
        }
        if(max!=null && max<=root.val){
            // breach of BST property
            flag2=false;
        }
        if(flag2)    inOrder2(root.right, root.val, max);
    }

    public boolean isValidBST(TreeNode root) {
        // inOrder1(root);
        // return flag;

        inOrder2(root,null,null);
        return flag2;
    }
}