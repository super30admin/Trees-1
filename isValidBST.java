// Time Complexity : O(n), where n is the number of nodes in the tree
// Space Complexity : O(h), where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * 1. Do inorder traversal and check if the previous node is less than the current node.
 * 2. If not, then the tree is not a valid BST.
 */

class Solution {
    TreeNode prev;
    boolean flag;

    public boolean isValidBST(TreeNode root) {
        this.prev = null;
        this.flag = true;
        validBST(root);

        return this.flag;
    }

    private void validBST(TreeNode root){
        if(root == null)
            return;
        
        validBST(root.left);
        System.out.print(root.val+" ");
        if(prev != null && prev.val >= root.val){
            this.flag = false;
            return;
        }
        
        prev = root;
        validBST(root.right);
    }
}