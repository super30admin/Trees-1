//Problem-1
// Time Complexity :O(h) height of the tree
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :&Yes
// Any problem you faced while coding this : Here we do that on based on the logic of inorder traversal of a binary tree
//is in the increasing order. We will check if inorder traversal is increasing order or not. If so we return true else false.

class Solution {
    TreeNode prev;
    Boolean flag;
    public boolean isValidBST(TreeNode root) {
        flag=true;
        inorder(root);
        return flag;

    }
    public void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        if(prev != null && prev.val>=root.val) flag=false;
        prev=root;
        inorder(root.right);
    }
}

//Problem-2 It is in trees 2. I will submit at that time
